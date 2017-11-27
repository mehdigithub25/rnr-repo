package gui.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import rnr.care.entities.Event;
import rnr.care.entities.User;
import rnr.care.services.EventManagerRemote;
import rnr.care.services.UserConnectRemote;

public class AddEventController implements Initializable{
	@FXML
	TextField title;
	@FXML
	TextField loc;
	@FXML
	TextField number;
	@FXML
	TextArea description;
	@FXML
	DatePicker date;
	@FXML
	Button add;
	@FXML
	CheckBox vip;
	@FXML
	CheckBox vol;
@FXML
Button back;
@FXML
ImageView imagevi;

	User u;
	
	@FXML 
	private void handleVipBox() {
		if(vip.isSelected()) {
			vol.setSelected(false);
		}
	}
	
	@FXML 
	private void handleVolBox() {
		if(vol.isSelected()) {
			vip.setSelected(false);
		}
	}
	
	public void AddEvent(ActionEvent even) throws NamingException {
		
		Context context = new InitialContext();
		
		String jndi = "rnr.care-ear/rnr.care-ejb/EventManager!rnr.care.services.EventManagerRemote";
		EventManagerRemote eventManagementRemote = (EventManagerRemote) context.lookup(jndi);

		
		Date dd = java.sql.Date.valueOf(date.getValue());
		
	String type;
	
		String t = title.getText();
		String c = loc.getText();
		String d = description.getText();
		int nmb=0;
		String text; 
		
		text = number.getText();
		if (text.contains("[a-zA-Z]+") == false ) {
		    
		    nmb = Integer.parseInt(number.getText());
		}  
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("participants number must be int!");
			alert.show();
		}
		
		
		if(vip.isSelected()) {
			type="vip";
		}
		else
			type="volunteer";
		// String ty = (String) type.getSelectionModel().getSelectedItem();
		// Boolean ty = type.getItems().addAll("VIP", "Volunteering");

	
Event e = new Event(t, d, c,dd,type, nmb,u);
		eventManagementRemote.saveOrUpdateEvent(e);
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Success!");
		alert.show();
	}


	public UserConnectRemote UCR() throws NamingException {
		Context context = new InitialContext();
		String jndi1 = "rnr.care-ear/rnr.care-ejb/UserConnect!rnr.care.services.UserConnectRemote";
		UserConnectRemote userConnectRemote = (UserConnectRemote) context.lookup(jndi1);
		return userConnectRemote;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		File file = new
				File("C:/Users/ASUS/git/rnr-repo/rnr.care/rnr.care-ejb/src/main/java/rnr/care/services/35465915064_0767cf4616_o.jpg");
			 Image image = new Image(file.toURI().toString());
				 imagevi.setImage(image);
		try {
			u=UCR().getUserConnected();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	
///////////
	
	 @FXML
	    public void backEvent(ActionEvent ae) throws IOException{
	        Parent page4 = FXMLLoader.load(getClass().getResource("/gui/Fx/WelcomeFX.fxml"));
	                Scene scene = new Scene(page4);
	                Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
	                stage.setScene(scene);
	                stage.show();
	    }
}
