package gui.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import rnr.care.entities.Event;
import rnr.care.entities.Participation;
import rnr.care.entities.User;
import rnr.care.services.EventManagerRemote;
import rnr.care.services.ParticipationManagementRemote;
import rnr.care.services.UserConnectRemote;
import rnr.care.services.UserManagerRemote;

public class SearchEventController implements Initializable {

	@FXML
	TableView<Event> table;

	@FXML
	TableColumn eventtitle;
	@FXML
	TableColumn description;
	@FXML
	TableColumn eventlocation;
	@FXML
	TableColumn eventdate;
	@FXML
	TableColumn eventtype;
	@FXML
	TableColumn number;

	@FXML
	Label interfaceLabel;
	@FXML
	Label label2;

	@FXML
	TextField title1;
	@FXML
	TextField loc1;
	@FXML
	TextArea description1;
	@FXML
	TextField type1;
	@FXML
	TextField number1;
	@FXML
	TextField loc;
	@FXML
	TextField title;
	@FXML
	TextField name;
	@FXML
	TextField nom;
	
	
	@FXML
	DatePicker date;

	@FXML
	Button all;
	@FXML
	Button search;
	@FXML
	Button participate;
	

	@FXML
	Label idd;
	@FXML
	Label idu;

	 @FXML
	 ImageView imagevi;
@FXML
Button back;
	
	List<Participation> participations;
	List<Event> event;
	List<Event> events;
	User u;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		File file = new
		File("C:/Users/ASUS/git/rnr-repo/rnr.care/rnr.care-ejb/src/main/java/rnr/care/services/35465915064_0767cf4616_o.jpg");
	 Image image = new Image(file.toURI().toString());
		 imagevi.setImage(image);
		try {
			Context context;

			context = new InitialContext();
			u = UCR().getUserConnected();
			String jndi = "rnr.care-ear/rnr.care-ejb/EventManager!rnr.care.services.EventManagerRemote";
			EventManagerRemote eventManagementRemote = (EventManagerRemote) context.lookup(jndi);

		} catch (Exception e) {
			// TODO: handle exception
		}

		table.getSelectionModel().selectedItemProperty()
				.addListener((ObservableValue<? extends Event> observable, Event oldValue, Event newValue) -> {
					if (newValue == null) {
						return;
					}
					getEventInfo(newValue.getId(),newValue.getAssociationAgent().getIdUser());

				});

		// try {
		// ShowEvent();
		// } catch (NamingException e) {
		// e.printStackTrace();
		// }

	}

	///////////////////////////////////////////////////////////

	private void getEventInfo(Integer id,int user) {
		try {
			if (id == null) {
				return;
			}
			Context context = new InitialContext();

			String jndi = "rnr.care-ear/rnr.care-ejb/EventManager!rnr.care.services.EventManagerRemote";
			EventManagerRemote eventManagementRemote = (EventManagerRemote) context.lookup(jndi);
			String jndi1 = "rnr.care-ear/rnr.care-ejb/UserManager!rnr.care.services.UserManagerRemote";
			UserManagerRemote userManagementRemote = (UserManagerRemote) context.lookup(jndi1);
			Event event = eventManagementRemote.findEventById(id);
			User us=userManagementRemote.findUserById(user);
			nom.setText(us.getUserName());
			idd.setText(Integer.toString(event.getId()));
			title1.setText(event.getTitle());
			description1.setText(event.getDescription());
			loc1.setText(event.getLocation());
			type1.setText(event.getType());
		} catch (Exception ex) {
			// Logger.getLogger(Users1Controller.class.getName()).log(Level.SEVERE, null,
			// ex);
		}

	}

	/////////////////////////////////////////////

	public void ShowEvent() throws NamingException {
		Task<List<Event>> task = new Task() {
			Context context = new InitialContext();
			String jndi = "rnr.care-ear/rnr.care-ejb/EventManager!rnr.care.services.EventManagerRemote";
			EventManagerRemote eventManagementRemote = (EventManagerRemote) context.lookup(jndi);

			@Override
			protected Object call() {
				// Platform.runLater(() -> prog.setVisible(true));

				event = eventManagementRemote.findAllEvents();
				return event;
			}
		};

		task.setOnSucceeded(e -> {

			eventtitle.setCellValueFactory(new PropertyValueFactory<>("title"));
			description.setCellValueFactory(new PropertyValueFactory<>("description"));
			eventlocation.setCellValueFactory(new PropertyValueFactory<>("location"));
			eventdate.setCellValueFactory(new PropertyValueFactory<>("date"));

			eventtype.setCellValueFactory(new PropertyValueFactory<>("type"));
			number.setCellValueFactory(new PropertyValueFactory<>("partnumber"));
			table.setItems(FXCollections.observableArrayList(task.getValue()));
		});
		task.setOnFailed(e -> {
			try {
				ShowEvent();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		Thread th = new Thread(task);
		th.start();
	}

	////////////////////////////////////////////////////////

	public void AddParticipation(ActionEvent even) throws NamingException {
		Context context = new InitialContext();

		String jndi = "rnr.care-ear/rnr.care-ejb/EventManager!rnr.care.services.EventManagerRemote";
		EventManagerRemote eventManagementRemote = (EventManagerRemote) context.lookup(jndi);

		String jndi1 = "rnr.care-ear/rnr.care-ejb/ParticipationManagement!rnr.care.services.ParticipationManagementRemote";
		ParticipationManagementRemote participationManagementRemote = (ParticipationManagementRemote) context
				.lookup(jndi1);

		Integer id = Integer.parseInt(idd.getText());
		Event event1 = eventManagementRemote.findEventById(id);

		Integer number = Integer.parseInt(number1.getText());

		int evnb = event1.getPartnumber();
		int nbr;
		nbr = evnb - number;
		//event1.setPartnumber(nbr);
if(nbr<0)
{

	Alert alert = new Alert(AlertType.ERROR);
	alert.setTitle("Information Dialog");
	alert.setHeaderText(null);
	alert.setContentText("no place!");
	alert.show();
	}else {
		event1.setPartnumber(nbr);
	
		
		Date d1 = (Date) event1.getDate();
		int id2=u.getIdUser();
		int T;
	 participations=	participationManagementRemote.findAllParticicpations();
	 T=0;
	 for(Participation p :participations) {
		
		 
		
		 if((p.getUser().getIdUser()==id2)&&(p.getEvent().getId()==id))
			 
			T=1;
	 }	 
		 
		 
		 if(T==1) {
		 Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("you have already participated!");
				alert.show();
				 ShowEvent();
				
			 }else {
				 participationManagementRemote.saveOrUpdateParticipation(number,d1, event1, u);
					eventManagementRemote.updateEvent(event1);
					 Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Information Dialog");
						alert.setHeaderText(null);
						alert.setContentText("you have successfully participated!");
						alert.show();
						 ShowEvent();
				
		 }
		 T=0;
	}
	}
			
	 
		

	///////////////////////////////////////////////////

	public UserConnectRemote UCR() throws NamingException {
		Context context = new InitialContext();
		String jndi1 = "rnr.care-ear/rnr.care-ejb/UserConnect!rnr.care.services.UserConnectRemote";
		UserConnectRemote userConnectRemote = (UserConnectRemote) context.lookup(jndi1);
		return userConnectRemote;
	}

	//////////////////////////////////////
	
	
			
	
	//////////////////////////////////////////////

	public void SearchShow() throws NamingException {

		Task<List<Event>> task = new Task() {
			Context context = new InitialContext();
			String jndi = "rnr.care-ear/rnr.care-ejb/EventManager!rnr.care.services.EventManagerRemote";
			EventManagerRemote eventManagementRemote = (EventManagerRemote) context.lookup(jndi);
			//Date dd=	java.sql.Date.valueOf(date.getValue());
			@Override
			protected Object call() {
				// Platform.runLater(() -> prog.setVisible(true));
			
				//events = eventManagementRemote.findEventByMultiChoices(title.getText(), loc.getText());

				return events;
			}
		};

		task.setOnSucceeded(e -> {

			eventtitle.setCellValueFactory(new PropertyValueFactory<>("title"));
			description.setCellValueFactory(new PropertyValueFactory<>("description"));
			eventlocation.setCellValueFactory(new PropertyValueFactory<>("location"));
			eventdate.setCellValueFactory(new PropertyValueFactory<>("date"));

			eventtype.setCellValueFactory(new PropertyValueFactory<>("type"));
			number.setCellValueFactory(new PropertyValueFactory<>("partnumber"));
			table.setItems(FXCollections.observableArrayList(task.getValue()));
		});
		task.setOnFailed(e -> {
			try {
				SearchShow();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		Thread th = new Thread(task);
		th.start();
	}
//////////////////
///////////
	
@FXML
  public void backEvent(ActionEvent ae) throws IOException{
      Parent page4 = FXMLLoader.load(getClass().getResource("/gui/Fx/WelcomeFX.fxml"));
              Scene scene = new Scene(page4);
              Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();}
}
