package gui.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import rnr.care.entities.Member;
import rnr.care.entities.User;
import rnr.care.services.UserConnectRemote;
import rnr.care.services.UserManagerRemote;

public class VolunteeringTestController {

	public UserConnectRemote UCR() throws NamingException {
		Context context = new InitialContext();
		String jndi1 = "rnr.care-ear/rnr.care-ejb/UserConnect!rnr.care.services.UserConnectRemote";
		UserConnectRemote userConnectRemote = (UserConnectRemote) context.lookup(jndi1);
		return userConnectRemote;
	}

	public UserManagerRemote UMR() throws NamingException {
		Context context = new InitialContext();
		String jndi = "rnr.care-ear/rnr.care-ejb/UserManager!rnr.care.services.UserManagerRemote";
		UserManagerRemote userManagementRemote = (UserManagerRemote) context.lookup(jndi);
		return userManagementRemote;
	}

	@FXML
	private CheckBox cbQ1R1;
	@FXML
	private CheckBox cbQ1R2;
	@FXML
	private CheckBox cbQ1R3;
	@FXML
	private CheckBox cbQ2R1;
	@FXML
	private CheckBox cbQ2R2;
	@FXML
	private CheckBox cbQ2R3;
	@FXML
	private CheckBox cbQ3R1;
	@FXML
	private CheckBox cbQ3R2;
	@FXML
	private CheckBox cbQ3R3;
	@FXML
	private CheckBox cbQ4R1;
	@FXML
	private CheckBox cbQ4R2;
	@FXML
	private CheckBox cbQ4R3;
	@FXML
	private CheckBox cbQ5R1;
	@FXML
	private CheckBox cbQ5R2;
	@FXML
	private CheckBox cbQ5R3;
	
	@FXML
	private Button btn_back ;
	User user;

	@FXML
	public void validateAction(ActionEvent ae) throws SQLException, IOException, NamingException {

		user = UCR().getUserConnected();
		int iduser = user.getIdUser();

		Member member = (Member) UCR().getUserConnected();

		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		int r = 0;

		//////

		/// question1
		if (cbQ1R1.isSelected()) {
			a = 1;
		} else if (cbQ1R2.isSelected()) {
			a = 0;
		} else if (cbQ1R3.isSelected()) {
			a = 2;
		}
		/// question2
		if (cbQ2R1.isSelected()) {
			b = 0;
		} else if (cbQ2R2.isSelected()) {
			b = 2;
		} else if (cbQ2R3.isSelected()) {
			b = 1;
		}
		/// question3
		if (cbQ3R1.isSelected()) {
			c = 1;
		} else if (cbQ3R2.isSelected()) {
			c = 0;
		} else if (cbQ3R3.isSelected()) {
			c = 2;
		}
		/// question4
		if (cbQ4R1.isSelected()) {
			d = 2;
		} else if (cbQ4R2.isSelected()) {
			d = 0;
		} else if (cbQ4R3.isSelected()) {
			d = 1;
		}
		/// question5
		if (cbQ5R1.isSelected()) {
			e = 1;
		} else if (cbQ5R2.isSelected()) {
			e = 0;
		} else if (cbQ5R3.isSelected()) {
			e = 2;
		}

		if (entryControl()) {

			r = a + b + c + d + e;

			if (r > 7) {

				Member member1 = new Member(iduser, member.getFirstName(), member.getLastName(), member.getUserName(),
						member.getPassword(), member.getEmail(), member.getAddress(), member.getNumPhone(), true);

				UMR().updateUser(member1);

				Parent page1 = FXMLLoader.load(getClass().getResource("/gui/Fx/WelcomeFX.fxml"));
				Scene scene = new Scene(page1);
				Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
				stage.setScene(scene);
				stage.show();

			} else {
				Member member1 = new Member(iduser, member.getFirstName(), member.getLastName(), member.getUserName(),
						member.getPassword(), member.getEmail(), member.getAddress(), member.getNumPhone(), false);

				UMR().updateUser(member1);

				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("sorry!");
				alert.setHeaderText(null);
				alert.setContentText("you failed in the test, you can try again");
				alert.showAndWait();
				
				Parent page1 = FXMLLoader.load(getClass().getResource("/gui/Fx/WelcomeFX.fxml"));
				Scene scene = new Scene(page1);
				Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
				stage.setScene(scene);
				stage.show();
			}
		}
	}

	private boolean entryControl() {
		if ((cbQ1R1.isSelected() == true && cbQ1R2.isSelected() == true)
				|| (cbQ1R1.isSelected() == true && cbQ1R3.isSelected() == true)
				|| (cbQ1R2.isSelected() == true && cbQ1R3.isSelected() == true)
				|| (cbQ2R1.isSelected() == true && cbQ2R2.isSelected() == true)
				|| (cbQ2R1.isSelected() == true && cbQ2R3.isSelected() == true)
				|| (cbQ2R2.isSelected() == true && cbQ2R3.isSelected() == true)
				|| (cbQ3R1.isSelected() == true && cbQ3R2.isSelected() == true)
				|| (cbQ3R1.isSelected() == true && cbQ3R3.isSelected() == true)
				|| (cbQ3R2.isSelected() == true && cbQ3R3.isSelected() == true)
				|| (cbQ4R1.isSelected() == true && cbQ4R2.isSelected() == true)
				|| (cbQ4R1.isSelected() == true && cbQ4R3.isSelected() == true)
				|| (cbQ4R2.isSelected() == true && cbQ4R3.isSelected() == true)
				|| (cbQ5R1.isSelected() == true && cbQ5R2.isSelected() == true)
				|| (cbQ5R1.isSelected() == true && cbQ5R3.isSelected() == true)
				|| (cbQ5R2.isSelected() == true && cbQ5R3.isSelected() == true)

		) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("warning!");
			alert.setHeaderText(null);
			alert.setContentText("select just one reply for each question , Thanks");
			alert.showAndWait();
			return false;

		}

		else
			return true;
	}
	
	@FXML
	public void backAction(ActionEvent ae) throws IOException {
		Parent page4 = FXMLLoader.load(getClass().getResource("/gui/Fx/Login.fxml"));
		Scene scene = new Scene(page4);
		Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
}
