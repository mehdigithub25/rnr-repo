package gui.controller;

import java.io.File;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import rnr.care.entities.Testimonial;
import rnr.care.services.TestimonalServiceRemote;

public class afficherTestimonal implements Initializable {
	private ObservableList<Testimonial> testi;
	private List<Testimonial> listestimonal;
	public static File file;
	public static Image image;
	@FXML
	private Pane pane1;

	@FXML
	private TableView<Testimonial> table_test;
	@FXML
	private TableColumn<Testimonial, String> Column_contenuu;
	@FXML
	private TableColumn<Testimonial, String> colum_btn;
	@FXML
	private TableColumn<Testimonial, String> Column_userr;
	@FXML
	private TableColumn<Testimonial, String> Colum_img;

	@FXML
	private ImageView imgToShow;

	@FXML
	private TextField txt_rechercher;
	@FXML
	private ImageView x2;

	@FXML
	private ImageView x3;

	@FXML
	private ImageView x1;

	@FXML
	private Button btn_del;

	@FXML
	private Button btn_mail;

	@FXML
	private Button btn_update;
	@FXML
	private Button txt_btn;
	@FXML
	private Button btn_back;

	private void setmouseclick() {
		table_test.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Testimonial tl = table_test.getItems().get(table_test.getSelectionModel().getSelectedIndex());

				int del = tl.getId_testimonal();

				// System.out.println(del);
				/*
				 * ss.setText(tl.getPic()); String ide=ss.getText();
				 * imgToShow.setImage(MyImage.fromResources(ide)); //combo_etat.getValue()
				 */

				Image img = new Image("http://localhost/ImagePi/" + tl.getImage());
				System.out.println("------------------------------");
				System.out.println("http://localhost/ImagePi/" + tl.getImage());

				imgToShow.setImage(img);

			}

		});

	}

	public void showTestimonal() throws NamingException {
		Task<List<Testimonial>> task = new Task() {
			Context context = new InitialContext();
			String jndi2 = "rnr.care-ear/rnr.care-ejb/TestimonalService!rnr.care.services.TestimonalServiceRemote";
			TestimonalServiceRemote testimonial = (TestimonalServiceRemote) context.lookup(jndi2);

			@Override
			protected Object call() throws Exception {
				listestimonal = testimonial.findallTestimonal();
				return listestimonal;
			}

		};
		task.setOnSucceeded(e -> {

			Column_userr.setCellValueFactory(new PropertyValueFactory<>("user"));
			Column_contenuu.setCellValueFactory(new PropertyValueFactory<>("contenu"));

			Colum_img.setCellValueFactory(new PropertyValueFactory<>("image"));
			table_test.setItems(FXCollections.observableArrayList(task.getValue()));

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
	void OnupdateAction(ActionEvent event) throws SQLException, IOException, NamingException {
		Context context = new InitialContext();
		String jndi2 = "rnr.care-ear/rnr.care-ejb/TestimonalService!rnr.care.services.TestimonalServiceRemote";
		TestimonalServiceRemote testimonial = (TestimonalServiceRemote) context.lookup(jndi2);

		Testimonial tl = table_test.getItems().get(table_test.getSelectionModel().getSelectedIndex());

		testimonial.updateTestimonial(tl);
	}

	@FXML
	void ondelAction(ActionEvent event) throws SQLException, IOException, NamingException {
		Context context = new InitialContext();
		String jndi2 = "rnr.care-ear/rnr.care-ejb/TestimonalService!rnr.care.services.TestimonalServiceRemote";
		TestimonalServiceRemote testimonial = (TestimonalServiceRemote) context.lookup(jndi2);

		Testimonial tl = table_test.getItems().get(table_test.getSelectionModel().getSelectedIndex());
		// Column_contenu.setText(tl.getContenu());
		int del = tl.getId_testimonal();

		System.out.println(del);

		testimonial.deleteTestimonialById(del);
		Notifications notification = Notifications.create().title("Delete success").text("Added success").graphic(null)
				.hideAfter(Duration.seconds(5)).position(Pos.BOTTOM_RIGHT).onAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						System.out.println("delete sucess");
					}
				});
		// testimonial.deleteTestimonialById(t.getId_testimonal());
	}

	@FXML
	void onmailAction(ActionEvent event) throws SQLException, IOException, NamingException {
		Parent page1 = FXMLLoader.load(getClass().getResource("/gui/Fx/MAIL.fxml"));
		Scene scene = new Scene(page1);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void onComme(ActionEvent event) throws SQLException, IOException, NamingException {
		Parent page1 = FXMLLoader.load(getClass().getResource("/gui/Fx/Commentaire.fxml"));
		Scene scene = new Scene(page1);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void bck(ActionEvent event) {
	/*	String domain = "https://www.google.fr/?gws_rd=ssl";
		String appId = "1264247583623638";
		// donner permission access au utilisateur
		String authUrl = "https://twitter.com/login?lang=fr";
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(authUrl);
		String accessToken;

		while (true) {

			if (!driver.getCurrentUrl().contains("facebook.com")) {
				String url = driver.getCurrentUrl();
				accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");

			}
		}
		*/
	}

	@FXML
	void back(ActionEvent event) throws SQLException, IOException, NamingException {
		Parent page1 = FXMLLoader.load(getClass().getResource("/gui/Fx/Menu.fxml"));
		Scene scene = new Scene(page1);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			showTestimonal();
			setmouseclick();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}