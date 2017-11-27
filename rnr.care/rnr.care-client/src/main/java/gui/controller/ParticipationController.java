package gui.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rnr.care.entities.Event;
import rnr.care.entities.Participation;
import rnr.care.entities.User;
import rnr.care.services.ParticipationManagementRemote;
import rnr.care.services.UserConnectRemote;

public class ParticipationController implements Initializable {
	@FXML
	TableColumn datecolumn;
	@FXML
	TableColumn numbercolumn;
	@FXML
	TableColumn activatecolumn;
	@FXML
	TableView<Participation> table_par;
	List<Participation> participation;
	User u,s;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
		Context context;
		context = new InitialContext();
		
		u = UCR().getUserConnected();
		ShowParticipants();
	} catch (Exception e) {
		// TODO: handle exception
	}
		
	

}
		public void ShowParticipants() throws NamingException {
			Task<List<Participation>> task = new Task() {
				Context context = new InitialContext();
				String jndi = "rnr.care-ear/rnr.care-ejb/ParticipationManagement!rnr.care.services.ParticipationManagementRemote";
				ParticipationManagementRemote participationManagementRemote = (ParticipationManagementRemote) context.lookup(jndi);

			//	Integer id = Integer.parseInt(idd.getText());
				
				@Override
				protected Object call() {
					// Platform.runLater(() -> prog.setVisible(true));

					participation = participationManagementRemote.findAllParticicpations();
					return participation;
				}
			};

			task.setOnSucceeded(e -> {
				
				
				datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));
				numbercolumn.setCellValueFactory(new PropertyValueFactory<>("numberparticipant"));
				activatecolumn.setCellValueFactory(new PropertyValueFactory<>("numberparticipant"));
				table_par.setItems(FXCollections.observableArrayList(task.getValue()));
			});
			task.setOnFailed(e -> {
				try {
					ShowParticipants();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			Thread th = new Thread(task);
			th.start();
		}
		
		
	
	
	public UserConnectRemote UCR() throws NamingException {
		Context context = new InitialContext();
		String jndi1 = "rnr.care-ear/rnr.care-ejb/UserConnect!rnr.care.services.UserConnectRemote";
		UserConnectRemote userConnectRemote = (UserConnectRemote) context.lookup(jndi1);
		return userConnectRemote;
	}

}
