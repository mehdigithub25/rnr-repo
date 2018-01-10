package gui.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.controlsfx.control.Notifications;



import gui.utils.Upload;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import rnr.care.entities.Testimonial;
import rnr.care.services.TestimonalServiceRemote;

public class Testimonal implements Initializable  {
	private ObservableList<Testimonial> testi;
	private List<Testimonial> listestimonal;
	public static File file;
	public static Image image;
	@FXML
	private TextArea Column_contenu;
	@FXML
	private Pane pane;

	@FXML
	private Button btn_afficher;

	@FXML
	private Button btn_add;
	@FXML
	private Button image_select;
	@FXML
	private ImageView imgToShow;
	@FXML
	private TextField ss;
	
	
	@FXML
	private Label label;
	@FXML
	private Button btn_retour;
	@FXML
	private Label lab2;
	@FXML
	private ComboBox typetem;
	


	@FXML
	void pathimage(ActionEvent event) throws IOException {
		File selectedfile;
		String path_img;
		Upload up = new Upload();

		FileChooser fc = new FileChooser();
		// fc.setInitialDirectory(new File ("C:\\Users\\user\\Desktop\\img"));

		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png", "*.PNG", "*.JPG"));

		selectedfile = fc.showOpenDialog(null);

		if (selectedfile != null) {

			BufferedImage bufferedImage = ImageIO.read(selectedfile);
			path_img = selectedfile.getName();
			ss.setText(path_img);
			WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
			imgToShow.setImage(image);

			up.upload(selectedfile);
		} else {
			System.out.println("FICHIER erroné");
		}

	}

	

	@FXML
	void addTesti(ActionEvent event) throws SQLException, IOException, NamingException {
		Context context;
		// initiate the naming context with the JNDI directory
		context = new InitialContext();
		// request for proxy injection from the container with the loocup method
		// and through the business interface Remote

		String jndi2 = "rnr.care-ear/rnr.care-ejb/TestimonalService!rnr.care.services.TestimonalServiceRemote";
		TestimonalServiceRemote testimonial = (TestimonalServiceRemote) context.lookup(jndi2);

		String type = (String) typetem.getSelectionModel().getSelectedItem();
		Testimonial t = new Testimonial(type, ss.getText(), Column_contenu.getText());

		try {
			boolean isnotAlphNom = validation.TextFieldValidation.textalphabet(Column_contenu, label,
					"verifier votre saisi");
			if (isnotAlphNom) {
				label.setText("");
			}
			if ((isnotAlphNom)) {
				testimonial.addTestimonial(t);
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
		

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	  @FXML
	    void onbackbutton(ActionEvent event)throws SQLException, IOException, NamingException {
		  Parent page1 = FXMLLoader.load(getClass().getResource("/gui/Fx/Menu.fxml"));
			Scene scene = new Scene(page1);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
	    }

		

	@FXML
	void onafficher(ActionEvent event)throws SQLException, IOException, NamingException {

		Parent page1 = FXMLLoader.load(getClass().getResource("/gui/Fx/AfficherTestimonal.fxml"));
		Scene scene = new Scene(page1);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 typetem.getItems().addAll("association","personel","groupe");
	}

}
