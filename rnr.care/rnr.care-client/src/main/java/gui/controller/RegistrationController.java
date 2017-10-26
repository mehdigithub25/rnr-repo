package gui.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import rnr.care.entities.Member;
import rnr.care.entities.User;
import rnr.care.services.UserConnectRemote;
import rnr.care.services.UserManagerRemote;

public class RegistrationController {

	ObservableList<String> options = FXCollections.observableArrayList("member", "vet", "trainer", "association agent",
			"insurance agent");

	@FXML
	private Button login;

	@FXML
	private TextField authUser;

	@FXML
	private TextField authPsswd;

	@FXML
	private AnchorPane PaneMain;

	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField userName;
	@FXML
	private TextField password;
	@FXML
	private TextField email;
	@FXML
	private TextField address;
	@FXML
	private TextField numPhone;
	@FXML
	private Button btn_register;
	@FXML
	private ChoiceBox choiceId;

	// @FXML
	// private void initialize() {
	// choiceId.setValue("member");
	// choiceId.setItems(options);

	// }

	// @FXML
	// public void refrechAction(ActionEvent ae) throws SQLException, IOException {

	// String output = choiceId.getValue().toString();
	// System.out.println(output);

	// if (output.compareTo("member") == 0) {

	// numPhone.setDisable(true);

	// }
	// else {
	// numPhone.setDisable(false);
	// }
	// }

	@FXML
	public void RegisterAction(ActionEvent ae) throws SQLException, IOException, NamingException {

		Context context = new InitialContext();
		String jndi = "rnr.care-ear/rnr.care-ejb/UserManager!rnr.care.services.UserManagerRemote";
		UserManagerRemote userManagementRemote = (UserManagerRemote) context.lookup(jndi);

		int phone = Integer.parseInt(numPhone.getText());

		Member member = new Member(firstName.getText(), lastName.getText(), userName.getText(), password.getText(),
				email.getText(), address.getText(), phone);

		userManagementRemote.addUser(member);

		Parent page1 = FXMLLoader.load(getClass().getResource("/gui/Fx/SuccessfulRegistration.fxml"));
		Scene scene = new Scene(page1);
		Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}

	@FXML
	public void LoginAction(ActionEvent ae) throws SQLException, IOException, NamingException {

		Context context = new InitialContext();
		String jndi = "rnr.care-ear/rnr.care-ejb/UserManager!rnr.care.services.UserManagerRemote";
		UserManagerRemote userManagementRemote = (UserManagerRemote) context.lookup(jndi);

		String jndi1 = "rnr.care-ear/rnr.care-ejb/UserConnect!rnr.care.services.UserConnectRemote";
		UserConnectRemote userConnectRemote = (UserConnectRemote) context.lookup(jndi1);

		// List li = (List) userManagementRemote.findbylogin(authUser.getText(),
		// authPsswd.getText());
		// if (li.isEmpty()) {
		// System.out.println("empty");
		// } else {

		User user = userManagementRemote.findbylogin(authUser.getText(), authPsswd.getText());

		userConnectRemote.logIn(user);

		Parent page1 = FXMLLoader.load(getClass().getResource("/gui/Fx/WelcomeFX.fxml"));
		Scene scene = new Scene(page1);
		Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
		// }

	}
	

	
	


}
