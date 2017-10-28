package gui.controller;

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
import javafx.stage.Stage;
import rnr.care.services.UserConnectRemote;

public class LoginController implements Initializable {

	@FXML
	Label welcomeLabel;
	@FXML
	Button btn_updateProfile ;


	public UserConnectRemote UCR() throws NamingException {
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
    public void update(ActionEvent ae) throws IOException{
        Parent page4 = FXMLLoader.load(getClass().getResource("/gui/Fx/UpdateUserFx.fxml"));
                Scene scene = new Scene(page4);
                Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
    }
    
    

}
