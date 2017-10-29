package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import rnr.care.entities.AssociationAgent;
import rnr.care.entities.InsuranceAgent;
import rnr.care.entities.Member;
import rnr.care.entities.Professional;
import rnr.care.entities.User;
import rnr.care.services.UserConnectRemote;
import rnr.care.services.UserManagerRemote;

public class UpdateUserController implements Initializable {

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
	private Button btn_update;
	@FXML
	private Button btn_back;

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
	User user;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		// membership.setValue("member");
		specialty.setItems(FXCollections.observableArrayList("Dog", "cat", "sheep", "bird", "horse", "pets",
				"animals of campaign"));

		try {
			user = UCR().getUserConnected();

			String userclass = user.getClass().toString();

			System.out.println(userclass);

			if (userclass.equals("class rnr.care.entities.Member")) {

				Member member = (Member) UCR().getUserConnected();

				String phone = Integer.toString(member.getNumPhone());

				firstName.setText(member.getFirstName());
				lastName.setText(member.getLastName());
				userName.setText(member.getUserName());
				email.setText(member.getEmail());
				password.setText(member.getPassword());
				address.setText(member.getAddress());
				numPhone.setText(phone);

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

			} else if (userclass.equals("class rnr.care.entities.Professional")) {

				Professional pro = (Professional) UCR().getUserConnected();

				String phone = Integer.toString(pro.getNumPhone());

				firstName.setText(pro.getFirstName());
				lastName.setText(pro.getLastName());
				userName.setText(pro.getUserName());
				email.setText(pro.getEmail());
				password.setText(pro.getPassword());
				address.setText(pro.getAddress());
				numPhone.setText(phone);
				specialty.setValue(pro.getSpecialty());
				officeAddress.setText(pro.getOfficeAddress());
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

			} else if (userclass.equals("class rnr.care.entities.InsuranceAgent")) {

				InsuranceAgent ia = (InsuranceAgent) UCR().getUserConnected();

				String phone = Integer.toString(ia.getNumPhone());

				firstName.setText(ia.getFirstName());
				lastName.setText(ia.getLastName());
				userName.setText(ia.getUserName());
				email.setText(ia.getEmail());
				password.setText(ia.getPassword());
				address.setText(ia.getAddress());
				numPhone.setText(phone);
				agency.setText(ia.getAgency());

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

			} else if (userclass.equals("class rnr.care.entities.AssociationAgent")) {

				AssociationAgent aa = (AssociationAgent) UCR().getUserConnected();

				String phone = Integer.toString(aa.getNumPhone());

				firstName.setText(aa.getFirstName());
				lastName.setText(aa.getLastName());
				userName.setText(aa.getUserName());
				email.setText(aa.getEmail());
				password.setText(aa.getPassword());
				address.setText(aa.getAddress());
				numPhone.setText(phone);
				activity.setText(aa.getActivity());
				associationName.setText(aa.getAssociationName());

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
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// int iduser= user.getIdUser();

		// User user1= userManagementRemote.findUserById(iduser) ;

	}

	@FXML
	public void updateAction(ActionEvent ae) throws SQLException, IOException, NamingException {

		if (entryControl()) {

			Context context = new InitialContext();
			String jndi = "rnr.care-ear/rnr.care-ejb/UserManager!rnr.care.services.UserManagerRemote";
			UserManagerRemote userManagementRemote = (UserManagerRemote) context.lookup(jndi);

			int phone = Integer.parseInt(numPhone.getText());

			user = UCR().getUserConnected();
			int iduser = user.getIdUser();

			Member member1 = (Member) UMR().findUserById(iduser);

			String userclass = user.getClass().toString();

			if (userclass.equals("class rnr.care.entities.Member")) {

				Member member = new Member(iduser, firstName.getText(), lastName.getText(), userName.getText(),
						password.getText(), email.getText(), address.getText(), phone, member1.isVolunteer());

				System.out.println(member1.isVolunteer());

				userManagementRemote.updateUser(member);

			} else if (userclass.equals("class rnr.care.entities.Professional")) {

				Professional pro1 = (Professional) UCR().getUserConnected();
				Professional pro = new Professional(iduser, firstName.getText(), lastName.getText(), userName.getText(),
						password.getText(), email.getText(), address.getText(), phone, specialty.getValue(),
						officeAddress.getText(), pro1.getType());

				userManagementRemote.updateUser(pro);

			} else if (userclass.equals("class rnr.care.entities.InsuranceAgent")) {

				InsuranceAgent ia = new InsuranceAgent(iduser, firstName.getText(), lastName.getText(),
						userName.getText(), password.getText(), email.getText(), address.getText(), phone,
						agency.getText());

				userManagementRemote.updateUser(ia);

			} else if (userclass.equals("class rnr.care.entities.AssociationAgent")) {

				AssociationAgent aa = new AssociationAgent(iduser, firstName.getText(), lastName.getText(),
						userName.getText(), password.getText(), email.getText(), address.getText(), phone,
						activity.getText(), associationName.getText());

				userManagementRemote.updateUser(aa);

			}

			Parent page1 = FXMLLoader.load(getClass().getResource("/gui/Fx/WelcomeFX.fxml"));
			Scene scene = new Scene(page1);
			Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		}
	}

	private boolean entryControl() throws NamingException {

		user = UCR().getUserConnected();

		String userclass = user.getClass().toString();

		if ((userclass.equals("class rnr.care.entities.Member"))
				&& ("".equals(firstName.getText()) || ("".equals(lastName.getText())) || ("".equals(userName.getText()))
						|| ("".equals(email.getText())) || ("".equals(password.getText()))
						|| ("".equals(address.getText())) || ("".equals(numPhone.getText())))) {

			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("warning!");
			alert.setHeaderText(null);
			alert.setContentText("Please fill all the fields, Thanks");
			alert.showAndWait();

			return false;
		} else if ((userclass.equals("class rnr.care.entities.Professional")) && ("".equals(firstName.getText())
				|| ("".equals(lastName.getText())) || ("".equals(userName.getText())) || ("".equals(email.getText()))
				|| ("".equals(password.getText())) || ("".equals(address.getText())) || ("".equals(numPhone.getText()))
				|| ("".equals(specialty.getValue())) || ("".equals(officeAddress.getText())))) {

			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("warning!");
			alert.setHeaderText(null);
			alert.setContentText("Please fill all the fields, Thanks");
			alert.showAndWait();

			return false;
		} else if (userclass.equals("class rnr.care.entities.InsuranceAgent") && ("".equals(firstName.getText())
				|| ("".equals(lastName.getText())) || ("".equals(userName.getText())) || ("".equals(email.getText()))
				|| ("".equals(password.getText())) || ("".equals(address.getText())) || ("".equals(numPhone.getText()))
				|| ("".equals(agency.getText())))) {

			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("warning!");
			alert.setHeaderText(null);
			alert.setContentText("Please fill all the fields, Thanks");
			alert.showAndWait();

			return false;
		}

		else if (userclass.equals("class rnr.care.entities.AssociationAgent") && ("".equals(firstName.getText())
				|| ("".equals(lastName.getText())) || ("".equals(userName.getText())) || ("".equals(email.getText()))
				|| ("".equals(password.getText())) || ("".equals(address.getText())) || ("".equals(numPhone.getText()))
				|| ("".equals(activity.getText())) || ("".equals(associationName.getText())))) {

			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("warning!");
			alert.setHeaderText(null);
			alert.setContentText("Please fill all the fields, Thanks");
			alert.showAndWait();

			return false;
		}

		else {
			try {
				// int x = Integer.parseInt(numPhone.getText());
				return true;

			} catch (NumberFormatException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Erreur!");
				alert.setHeaderText(null);
				alert.setContentText("Please enter an integer in the phone field, Thanks ");
				alert.showAndWait();
				return false;
			}
		}

	}

	@FXML
	public void backAction(ActionEvent ae) throws IOException {
		Parent page4 = FXMLLoader.load(getClass().getResource("/gui/Fx/WelcomeFX.fxml"));
		Scene scene = new Scene(page4);
		Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

}
