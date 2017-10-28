package gui.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SuccessFullController {

	@FXML
	Label success_lab;
	@FXML
	Button btn_back;

	@FXML
	public void retour(ActionEvent ae) throws IOException {
		Parent page4 = FXMLLoader.load(getClass().getResource("/gui/Fx/Login.fxml"));
		Scene scene = new Scene(page4);
		Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}



}
