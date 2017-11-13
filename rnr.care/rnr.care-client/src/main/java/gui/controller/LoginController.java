package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import rnr.care.entities.Member;
import rnr.care.entities.User;
import rnr.care.services.UserConnectRemote;
import rnr.care.services.UserManagerRemote;

public class LoginController implements Initializable {

	private ObservableList<Member> volunteers;
	@FXML
	Label welcomeLabel;
	@FXML
	Button btn_updateProfile;
	@FXML
	Button btn_volunteering;
	@FXML
	Label volunteerLab;
	@FXML
	private TableColumn<Member, String> colFirstName;
	@FXML
	private TableColumn<Member, String> colLastName;
	@FXML
	private TableColumn<Member, Integer> colPhone;
	@FXML
	private TableColumn<Member, String> colEmail;
	@FXML
	private TableColumn<Member, String> colAddress;
	@FXML
	private TableView<Member> tableVolunteer;

	User user;

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

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		try {
			welcomeLabel.setText("welcome " + UCR().getUserConnected().getFirstName());

			user = UCR().getUserConnected();

			int iduser = user.getIdUser();

			Member member1 = (Member) UMR().findUserById(iduser);

			String userclass = user.getClass().toString();

			System.out.println(userclass);

			if (userclass.equals("class rnr.care.entities.Member")) {
				btn_volunteering.setVisible(true);
				tableVolunteer.setVisible(false);

				if (member1.isVolunteer()) {
					volunteerLab.setVisible(true);

				} else {
					volunteerLab.setVisible(false);
				}

			} else if (userclass.equals("class rnr.care.entities.AssociationAgent")) {

				tableVolunteer.setVisible(true);

				colFirstName.setCellFactory(TextFieldTableCell.forTableColumn());
				colLastName.setCellFactory(TextFieldTableCell.forTableColumn());
				colPhone.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
				colEmail.setCellFactory(TextFieldTableCell.forTableColumn());
				colAddress.setCellFactory(TextFieldTableCell.forTableColumn());
				//

				colFirstName.setCellValueFactory(new PropertyValueFactory<Member, String>("firstName"));
				colLastName.setCellValueFactory(new PropertyValueFactory<Member, String>("lastName"));
				colPhone.setCellValueFactory(new PropertyValueFactory<Member, Integer>("numPhone"));
				colEmail.setCellValueFactory(new PropertyValueFactory<Member, String>("email"));
				colAddress.setCellValueFactory(new PropertyValueFactory<Member, String>("address"));

				try {
					volunteers = GetAllVolunteer();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				tableVolunteer.setItems(volunteers);

				btn_volunteering.setVisible(false);
				volunteerLab.setVisible(false);
			} else {
				btn_volunteering.setVisible(false);
				volunteerLab.setVisible(false);
				tableVolunteer.setVisible(false);

			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private ObservableList<Member> GetAllVolunteer() throws SQLException, NamingException {

		ObservableList<Member> volunteers;

		List<Member> volunteerList = UMR().findAllVolunteer();

		volunteers = FXCollections.observableArrayList();
		for (Member r : volunteerList) {
			volunteers.add(r);
		}
		return volunteers;

	}

	@FXML
	public void backAction(ActionEvent ae) throws IOException {
		Parent page4 = FXMLLoader.load(getClass().getResource("/gui/Fx/Login.fxml"));
		Scene scene = new Scene(page4);
		Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void update(ActionEvent ae) throws IOException {
		Parent page4 = FXMLLoader.load(getClass().getResource("/gui/Fx/UpdateUserFx.fxml"));
		Scene scene = new Scene(page4);
		Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void testVolunteerAction(ActionEvent ae) throws IOException {
		Parent page4 = FXMLLoader.load(getClass().getResource("/gui/Fx/VolunteeringTestFx.fxml"));
		Scene scene = new Scene(page4);
		Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

}
