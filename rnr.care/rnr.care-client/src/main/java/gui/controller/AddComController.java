package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import rnr.care.entities.Comment;
import rnr.care.entities.User;
import rnr.care.services.CommentManagementRemote;
import rnr.care.services.PostManagementRemote;
import rnr.care.services.UserConnectRemote;
import rnr.care.services.UserManagerRemote;

public class AddComController implements Initializable {

	@FXML
	private TextArea contextPC;
	@FXML
	private Label titlePC;
	@FXML
	private TextArea contextC;
	@FXML
	private Button btnAc;
	@FXML
	private ListView<Comment> lstComment;

	@FXML
	public void AddPAction(ActionEvent ap) throws SQLException, IOException, NamingException {
		Context context = new InitialContext();
		String jndi = "rnr.care-ear/rnr.care-ejb/UserManager!rnr.care.services.UserManagerRemote";
		UserManagerRemote userMR = (UserManagerRemote) context.lookup(jndi);
		String jndi1 = "rnr.care-ear/rnr.care-ejb/UserConnect!rnr.care.services.UserConnectRemote";
		UserConnectRemote userConnectRemote = (UserConnectRemote) context.lookup(jndi1);
		String jndi2 = "rnr.care-ear/rnr.care-ejb/PostManagement!rnr.care.services.PostManagementRemote";
		PostManagementRemote PMR = (PostManagementRemote) context.lookup(jndi2);
		String jndi3 = "rnr.care-ear/rnr.care-ejb/CommentManagement!rnr.care.services.CommentManagementRemote";
		CommentManagementRemote commentMR = (CommentManagementRemote) context.lookup(jndi3);
		User u1 = userConnectRemote.getUserConnected();

		Comment comment = new Comment();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
