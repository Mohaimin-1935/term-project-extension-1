package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPlayerController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private Button backToHome;

    @FXML
    private TextField name;

    @FXML
    private TextField country;

    @FXML
    private TextField salary;

    @FXML
    private TextField position;

    @FXML
    private TextField age;

    @FXML
    private TextField height;

    @FXML
    private TextField club;

    @FXML
    private Label error;

    @FXML
    private Label success;

    @FXML
    private Button addPlayer;

    @FXML
    void handleAddPlayer(ActionEvent event) {

    }

    @FXML
    void handleBackToHome(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("home.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

}
