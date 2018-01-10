package gui.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Menu {

    @FXML
    private Button btn_testimonal;

    @FXML
    private Button btn_comment;

    @FXML
    void actiontestimonal(ActionEvent event) throws SQLException, IOException, NamingException {
    	 Parent page1 = FXMLLoader.load(getClass().getResource("/gui/Fx/Testimonal.fxml"));
         Scene scene = new Scene(page1);
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setScene(scene);
         stage.show();
	
    	
    	
    }

    @FXML
    void onActioncomment(ActionEvent event) throws SQLException, IOException, NamingException  {
    	
   	 Parent page2 = FXMLLoader.load(getClass().getResource("/gui/Fx/Commentaire.fxml"));
     Scene scene = new Scene(page2);
     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     stage.setScene(scene);
     stage.show();



    }

}
