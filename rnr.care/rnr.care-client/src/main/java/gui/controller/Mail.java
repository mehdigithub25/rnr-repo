package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Mail implements Initializable {

	@FXML
	private ComboBox from_combo;

	@FXML
	private TextField from_pwd;

	@FXML
	private TextField to_pwd;

	@FXML
	private ComboBox subj_combo;

	@FXML
	private Button send_btn;

	@FXML
	private TextArea msg_fild;

	@FXML
	void send(ActionEvent event) {
		rnr.care.entities.Mail m= new rnr.care.entities.Mail();
        String  pwd=from_pwd.getText();
         String  to=to_pwd.getText();
         String  msg=msg_fild.getText();
         
                 String from=(String) from_combo.getSelectionModel().getSelectedItem();
                String sujet =(String) subj_combo.getSelectionModel().getSelectedItem();
                m.send(from, pwd, to, sujet, msg);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		from_combo.getItems().addAll("azmi.ghis@esprit.tn");
		subj_combo.getItems().addAll("s'exprimer", "expliquer");
		// Materiel mat1= AjoutMaterielController.mat;
		// Materiel mat1= AjoutMaterielController.mat;
		// txt_nom.setText(mat1.getNom());

	}

}