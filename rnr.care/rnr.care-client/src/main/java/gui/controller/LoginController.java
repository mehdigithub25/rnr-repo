package gui.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import rnr.care.entities.User;
import rnr.care.services.UserConnectRemote;

public class LoginController implements Initializable {

	@FXML
	Label welcomeLabel;
	@FXML
	Button btn_back;
	@FXML
	Button btn_add;
	@FXML
	Button btn_show;
	@FXML
	Button btn_show1;
	 @FXML
	 ImageView imagevi;
	 
	public User user;

	public UserConnectRemote UCR() throws NamingException {
		File file = new
				File("C:/Users/ASUS/git/rnr-repo/rnr.care/rnr.care-ejb/src/main/java/rnr/care/services/a03ae9b70b28e9dd7e3b6480b1b7ee356989f3525815d123bc5d8bda97c249d0.gif");
			 Image image = new Image(file.toURI().toString());
				 imagevi.setImage(image);
		Context context = new InitialContext();
		String jndi1 = "rnr.care-ear/rnr.care-ejb/UserConnect!rnr.care.services.UserConnectRemote";
		UserConnectRemote userConnectRemote = (UserConnectRemote) context.lookup(jndi1);
		return userConnectRemote;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		try {
			welcomeLabel.setText("welcome "+UCR().getUserConnected().getFirstName());
			
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
    @FXML
    public void retour(ActionEvent ae) throws IOException{
        Parent page4 = FXMLLoader.load(getClass().getResource("/gui/Fx/Login.fxml"));
                Scene scene = new Scene(page4);
                Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    public void add(ActionEvent ae) throws IOException{
        Parent page5 = FXMLLoader.load(getClass().getResource("/gui/Fx/IAddEvent.fxml"));
                Scene scene = new Scene(page5);
                Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
    }
    @FXML
    public void show(ActionEvent ae) throws IOException{
        Parent page6 = FXMLLoader.load(getClass().getResource("/gui/Fx/IAllEvents.fxml"));
                Scene scene = new Scene(page6);
                Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
    }
    
    @FXML
    public void search(ActionEvent ae) throws IOException{
        Parent page7 = FXMLLoader.load(getClass().getResource("/gui/Fx/SearchEvent.fxml"));
                Scene scene = new Scene(page7);
                Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
    }
}
