package gui.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.CheckBox;
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

public class DesplayEventController implements Initializable {
    @FXML
    private Label interfaceLabel;

    @FXML
    private TextField title1;

    @FXML
    private TextField loc1;

    @FXML
    private DatePicker date1;

    @FXML
	private TextArea description1;

    @FXML
    private Button update;

    @FXML
    private TableView<Event> table;

    @FXML
    private TableColumn<Event, String> eventtitle;

    @FXML
    private TableColumn<Event, String> description;

    @FXML
    private TableColumn<Event, String> eventlocation;

    @FXML
    private TableColumn<Event, Date> eventdate;

    @FXML
    private TableColumn<Event, String> eventtype;

    @FXML
    private TableColumn<Event, Integer> number;

    @FXML
    private Label idd;

    @FXML
    private Button delete;

    @FXML
    private TextField number1;

    @FXML
    private Label idu;

    @FXML
    private CheckBox vip;

    @FXML
    private CheckBox vol;
    @FXML
    private ImageView a;

    @FXML
	TableColumn datecolumn;
	@FXML
	TableColumn numbercolumn;
	@FXML
	TableColumn activatecolumn;
	@FXML
	TableView<Participation> table_par;
	
	@FXML
	Button show;
	@FXML
	Button back;
	 @FXML
	 ImageView imagevi;
	
	
		List<Event> event;
		List<Participation> participation;
		User u,s;
		
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
						getEventInfo(newValue.getId());
						
					});

			try {
				ShowEvent();
				
			} catch (NamingException e) {
				e.printStackTrace();
			}

		}
	//////////////////////////////////////////////////////////////
		private void getEventInfo(Integer id) {
			try {
				if (id == null) {
					return;
				}
				Context context = new InitialContext();

				String jndi = "rnr.care-ear/rnr.care-ejb/EventManager!rnr.care.services.EventManagerRemote";
				EventManagerRemote eventManagementRemote = (EventManagerRemote) context.lookup(jndi);
				Event event = eventManagementRemote.findEventById(id);
				idd.setText(Integer.toString(event.getId()));
				title1.setText(event.getTitle());
				description1.setText(event.getDescription());
				loc1.setText(event.getLocation());

			} catch (Exception ex) {
				// Logger.getLogger(Users1Controller.class.getName()).log(Level.SEVERE, null,
				// ex);
			}

		}
	///////////////////////////////////////////////////////////////////
		public void ShowEvent() throws NamingException {
			Task<List<Event>> task = new Task() {
				Context context = new InitialContext();
				String jndi = "rnr.care-ear/rnr.care-ejb/EventManager!rnr.care.services.EventManagerRemote";
				EventManagerRemote eventManagementRemote = (EventManagerRemote) context.lookup(jndi);

				@Override
				protected Object call() {
					// Platform.runLater(() -> prog.setVisible(true));
					Integer iduser = u.getIdUser();
					event = eventManagementRemote.findEventByUser(iduser);
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

		///////////////////////////////////////////// code checkBox
		@FXML
		private void handleVipBox() {
			if (vip.isSelected()) {
				vol.setSelected(false);
			}
		}

		@FXML
		private void handleVolBox() {
			if (vol.isSelected()) {
				vip.setSelected(false);
			}
		}

		/////////////////////////////////////////////////////////////
		@FXML
		public void UpdateEvent(ActionEvent event) throws NamingException {

			Context context = new InitialContext();

			String jndi = "rnr.care-ear/rnr.care-ejb/EventManager!rnr.care.services.EventManagerRemote";
			EventManagerRemote eventManagementRemote = (EventManagerRemote) context.lookup(jndi);

			// String jndi1 =
			// "rnr.care-ear/rnr.care-ejb/UserManager!rnr.care.services.UserManagerRemote";
			// UserManagerRemote userManagementRemote = (UserManagerRemote)
			// context.lookup(jndi1);
			Integer id = Integer.parseInt(idd.getText());
Event ev=eventManagementRemote.findEventById(id);

			Event e = new Event();
			
			String title = title1.getText();
			String type;
			String description = description1.getText();
			
			
			Integer number = Integer.parseInt(number1.getText());

			String loc = loc1.getText();
			Date dd = java.sql.Date.valueOf(date1.getValue());

			if (vip.isSelected()) {
				type = "vip";
			} else
				type = "volunteer";

			e.setId(id);
			e.setTitle(title);
			User s = ev.getAssociationAgent();
			e.setAssociationAgent(s);
			e.setDescription(description);
			e.setPartnumber(number);
			e.setType(type);
			e.setLocation(loc);
			e.setDate(dd);

			eventManagementRemote.updateEvent(e);
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Updated!");
			alert.show();
			ShowEvent();

		}
///////////////////////////////////////
		@FXML
		public void DeleteEvent(ActionEvent event) throws NamingException {

			Context context = new InitialContext();

			String jndi = "rnr.care-ear/rnr.care-ejb/EventManager!rnr.care.services.EventManagerRemote";
			EventManagerRemote eventManagementRemote = (EventManagerRemote) context.lookup(jndi);

			Integer id = Integer.parseInt(idd.getText());

			eventManagementRemote.deleteEventById(id);
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Deleted!");
			alert.show();
			ShowEvent();
		}

		///////////////////////

		public UserConnectRemote UCR() throws NamingException {
			Context context = new InitialContext();
			String jndi1 = "rnr.care-ear/rnr.care-ejb/UserConnect!rnr.care.services.UserConnectRemote";
			UserConnectRemote userConnectRemote = (UserConnectRemote) context.lookup(jndi1);
			return userConnectRemote;
		}
	////////////////////////////
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
				activatecolumn.setCellValueFactory(new PropertyValueFactory<>("activate"));
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
		
	////////////////////////////
		@FXML
		  public void backEvent(ActionEvent ae) throws IOException{
		      Parent page4 = FXMLLoader.load(getClass().getResource("/gui/Fx/WelcomeFX.fxml"));
		              Scene scene = new Scene(page4);
		              Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
		              stage.setScene(scene);
		              stage.show();}
}
