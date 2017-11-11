package gui.userManager;

import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RnrCare extends Application {

	public static Stage PrimaryStage;

	private Stage stage;
	private Parent parent;

	public void start(Stage primaryStage) throws IOException {
		this.stage = primaryStage;
		parent = FXMLLoader.load(getClass().getResource("/gui/Fx/AddPost.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) throws SQLException {
		launch(args);
	}

}
