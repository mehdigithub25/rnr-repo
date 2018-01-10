package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.controlsfx.control.Notifications;





import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import rnr.care.entities.Commentaire;
import rnr.care.entities.Testimonial;
import rnr.care.services.CommentaireServiceRemote;

public class Comment implements Initializable {
	private ObservableList<Commentaire> comment;
	private List<Commentaire> listestimonal;
	@FXML
	private TextArea txt_comment;

	@FXML
	private Label lbcomment;
	 @FXML
	    private Pane paned;
	 @FXML
	    private Button btn_signal;
	@FXML
	private TableView<Commentaire> table_comm;

	@FXML
	private TableColumn<Commentaire, String> column_com;

	@FXML
	private TableColumn<Commentaire, String> user_comm;

	@FXML
	private TableColumn<Commentaire, String> test_comm;

	@FXML
	private TableColumn<Commentaire, String> nbre;
	@FXML
	private Button btn_add;
    @FXML
    private Button btn_back;
    @FXML
    private Button btn_comment;

	public void showTestimonal() throws NamingException {
		Task<List<Commentaire>> task = new Task() {
			Context context = new InitialContext();
			String jndi2 = "/rnr.care-ear/rnr.care-ejb/CommentaireService!rnr.care.services.CommentaireServiceRemote";
			CommentaireServiceRemote commentaire = (CommentaireServiceRemote) context.lookup(jndi2);

			@Override
			protected Object call() throws Exception {
				listestimonal = commentaire.findAllCommentaire();
				return listestimonal;
			}

		};
		task.setOnSucceeded(e -> {

			column_com.setCellValueFactory(new PropertyValueFactory<>("contenu"));
			nbre.setCellValueFactory(new PropertyValueFactory<>("nbCom"));

			user_comm.setCellValueFactory(new PropertyValueFactory<>("user"));
			test_comm.setCellValueFactory(new PropertyValueFactory<>("x"));
			table_comm.setItems(FXCollections.observableArrayList(task.getValue()));

		});
		task.setOnFailed(e -> {
			try {
				showTestimonal();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		Thread th = new Thread(task);

		th.start();
	}

	@FXML
	void onAddCom(ActionEvent event) throws SQLException, IOException, NamingException {
		Context context = new InitialContext();
		String jndi2 = "rnr.care-ear/rnr.care-ejb/CommentManagement!rnr.care.services.CommentManagementRemote";
		CommentaireServiceRemote commentaire = (CommentaireServiceRemote) context.lookup(jndi2);
		Commentaire c = new Commentaire(txt_comment.getText());
		
		commentaire.addCommentaire(c);
		Notifications notification = Notifications.create().title("Add success").text("Added success")
				.graphic(null).hideAfter(Duration.seconds(5)).position(Pos.BOTTOM_RIGHT)
				.onAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						System.out.println("add succes");
					}
				});
		notification.showConfirm();

	}
	  @FXML
	    void signalerAction(ActionEvent event)throws SQLException, IOException, NamingException {
		  Parent page1 = FXMLLoader.load(getClass().getResource("/gui/Fx/Signaler.fxml"));
	         Scene scene = new Scene(page1);
	         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	         stage.setScene(scene);
	         stage.show();
	    }
	  @FXML
	    void back(ActionEvent event)throws SQLException, IOException, NamingException {
		  Parent page1 = FXMLLoader.load(getClass().getResource("/gui/Fx/Menu.fxml"));
	         Scene scene = new Scene(page1);
	         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	         stage.setScene(scene);
	         stage.show();
	    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
try {
	showTestimonal();
} catch (NamingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}		// TODO Auto-generated method stub
		
	}

}