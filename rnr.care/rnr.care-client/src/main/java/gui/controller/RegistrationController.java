package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import rnr.care.entities.AssociationAgent;
import rnr.care.entities.InsuranceAgent;
import rnr.care.entities.Member;
import rnr.care.entities.Professional;
import rnr.care.entities.User;
import rnr.care.services.UserConnectRemote;
import rnr.care.services.UserManagerRemote;

public class RegistrationController implements Initializable {

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
	private TextField officeAddress;
	@FXML
	private TextField activity;
	@FXML
	private TextField associationName;
	@FXML
	private TextField agency;
	@FXML
	private Button btn_register;
	@FXML
	private ChoiceBox<String> membership;
	@FXML
	private ChoiceBox<String> specialty;
	@FXML
	private Text specialtuLab;
	@FXML
	private Text officeAddressLab;
	@FXML
	private Text activityLab;
	@FXML
	private Text associationNameLab;
	@FXML
	private Text agencyLab;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		membership.setItems(
				FXCollections.observableArrayList("member", "vet", "trainer", "insurance agent", "association agent"));
		// membership.setValue("member");

		membership.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// System.out.println("Value is: "+newValue);

				if (newValue.equals("member")) {

					specialtuLab.setVisible(false);
					officeAddressLab.setVisible(false);
					activityLab.setVisible(false);
					associationNameLab.setVisible(false);
					agencyLab.setVisible(false);
					officeAddress.setVisible(false);
					activity.setVisible(false);
					associationName.setVisible(false);
					agency.setVisible(false);
					specialty.setVisible(false);

				} else if (newValue.equals("vet") || newValue.equals("trainer")) {

					specialtuLab.setVisible(true);
					officeAddressLab.setVisible(true);
					activityLab.setVisible(false);
					associationNameLab.setVisible(false);
					agencyLab.setVisible(false);
					specialty.setVisible(true);
					officeAddress.setVisible(true);
					activity.setVisible(false);
					associationName.setVisible(false);
					agency.setVisible(false);

				} else if (newValue.equals("insurance agent")) {

					specialtuLab.setVisible(false);
					officeAddressLab.setVisible(false);
					activityLab.setVisible(false);
					associationNameLab.setVisible(false);
					agencyLab.setVisible(true);
					officeAddress.setVisible(false);
					activity.setVisible(false);
					associationName.setVisible(false);
					agency.setVisible(true);
					specialty.setVisible(false);

				} else if (newValue.equals("association agent")) {

					specialtuLab.setVisible(false);
					officeAddressLab.setVisible(false);
					activityLab.setVisible(true);
					associationNameLab.setVisible(true);
					agencyLab.setVisible(false);
					officeAddress.setVisible(false);
					activity.setVisible(true);
					associationName.setVisible(true);
					agency.setVisible(false);
					specialty.setVisible(false);

				}

			}
		});
	}

	// @FXML
	// public void refrechAction() throws SQLException, IOException {

	// membership.setItems(FXCollections.observableArrayList("member","vet","trainer"));
	// String output = membership.getSelectionModel().getSelectedItem().toString();
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

		String membershipValue = membership.getValue();

		System.out.println("  " + membershipValue);

		Member member = new Member(firstName.getText(), lastName.getText(), userName.getText(), password.getText(),
				email.getText(), address.getText(), phone);

		Professional pro = new Professional(firstName.getText(), lastName.getText(), userName.getText(),
				password.getText(), email.getText(), address.getText(), phone, specialty.getValue(),
				officeAddress.getText(), membershipValue);

		AssociationAgent aa = new AssociationAgent(firstName.getText(), lastName.getText(), userName.getText(),
				password.getText(), email.getText(), address.getText(), phone, activity.getText(),
				associationName.getText());

		InsuranceAgent ia = new InsuranceAgent(firstName.getText(), lastName.getText(), userName.getText(),
				password.getText(), email.getText(), address.getText(), phone, agency.getText());

		if (membershipValue.equals("member")) {

			userManagementRemote.addUser(member);

		} else if (membershipValue.equals("vet") || membershipValue.equals("trainer")) {

			userManagementRemote.addUser(pro);

		} else if (membershipValue.equals("insurance agent")) {

			userManagementRemote.addUser(ia);

		} else if (membershipValue.equals("association agent")) {

			userManagementRemote.addUser(aa);

		}

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
