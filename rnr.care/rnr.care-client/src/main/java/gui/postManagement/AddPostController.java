package gui.postManagement;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import rnr.care.entities.Category;
import rnr.care.entities.Post;
import rnr.care.entities.User;
import rnr.care.services.PostManagementRemote;
import rnr.care.services.UserConnectRemote;
import rnr.care.services.UserManagerRemote;

public class AddPostController implements Initializable {

	@FXML
	private Button ajouterPost;
	@FXML
	private TextArea statuPost;

	@FXML
	private ListView<Post> lstPost;

	@FXML
	private TextField titlePost;
	@FXML
	private ChoiceBox<Category> categoryPost;

	private ObservableList<Post> data;
	private String t;
	private String s;

	@FXML
	public void AddPAction(ActionEvent ap) throws SQLException, IOException, NamingException {
		Context context = new InitialContext();
		String jndi = "rnr.care-ear/rnr.care-ejb/UserManager!rnr.care.services.UserManagerRemote";
		UserManagerRemote userMR = (UserManagerRemote) context.lookup(jndi);
		String jndi1 = "rnr.care-ear/rnr.care-ejb/UserConnect!rnr.care.services.UserConnectRemote";
		UserConnectRemote userConnectRemote = (UserConnectRemote) context.lookup(jndi1);
		String jndi2 = "rnr.care-ear/rnr.care-ejb/PostManagement!rnr.care.services.PostManagementRemote";
		PostManagementRemote PMR = (PostManagementRemote) context.lookup(jndi2);
		User u1 = userConnectRemote.getUserConnected();
		Post p1 = new Post(titlePost.getText(), statuPost.getText(), categoryPost.getValue());

		PMR.addPost(p1);
		data.removeAll(data);
		data.addAll(FXCollections.observableArrayList(PMR.findAllPosts()));
		lstPost.refresh();

	}

	@FXML
	public void Affich() throws NamingException {
		Context context = new InitialContext();
		String jndi2 = "rnr.care-ear/rnr.care-ejb/PostManagement!rnr.care.services.PostManagementRemote";
		PostManagementRemote PMR = (PostManagementRemote) context.lookup(jndi2);
		List<Post> Posts = PMR.findAllPosts();
		data = FXCollections.observableArrayList(Posts);
		lstPost.setItems(data);
		lstPost.setCellFactory(new Callback<ListView<Post>, ListCell<Post>>() {

			@Override
			public ListCell<Post> call(ListView<Post> param) {
				ListCell<Post> cell;
				cell = new ListCell<Post>() {
					@Override
					protected void updateItem(Post p, boolean bln) {
						super.updateItem(p, bln);
						if (p != null) {
							HBox hBox = new HBox(10);
							VBox vBox = new VBox();
							HBox hbox1 = new HBox();
							Button appBtn = new Button();
							appBtn.setStyle("-fx-background-color:green");
							appBtn.setText("Comments");
							appBtn.setStyle("-fx-color: #ffffff");
							appBtn.setTranslateX(250);
							Button refBtn = new Button();
							Label title = new Label(p.getTitle());
							title.setStyle("-fx-color: #fff252");
							Label statut = new Label(p.getContext());
							statut.setAlignment(Pos.CENTER_RIGHT);
							hBox.getChildren().add(title);
							hBox.getChildren().add(statut);
							hBox.getChildren().add(appBtn);

							setGraphic(hBox);
							System.out.println("llllllllllllllllllllllllllllll" + p.getId());
							appBtn.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {

									try {
										FXMLLoader fxmlLoader = new FXMLLoader(
												getClass().getResource("/gui/Fx/AddComment.fxml"));
										Parent root1 = (Parent) fxmlLoader.load();
										Stage stage = new Stage();
										stage.setScene(new Scene(root1));
										stage.show();
									} catch (Exception e) {
										e.printStackTrace();
									}

								}

							});

							// lstPost.getSelectionModel().selectedItemProperty().addListener(arg0);
							// appBtn.setOnMouseClicked(e -> {

							// PMR.deletePostById(p.getId());
							// data.removeAll(data);

							// data.addAll(FXCollections.observableArrayList(PMR.findAllPosts()));
							// lstPost.refresh();
							// });

						} else {
							setGraphic(null);
						}
					}
				};
				return cell;
			}
		});
		lstPost.refresh();

	}

	public void cellPressed(ActionEvent event) throws Exception {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/Fx/AddComment.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		List<Category> data = Arrays.asList(Category.values());
		categoryPost.getItems().addAll(data);
		try {
			Affich();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
