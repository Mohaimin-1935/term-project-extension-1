package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController {
	
	private String filename;
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private Button searchClubButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button addPlayerButton;

    @FXML
    private Button searchPlayerButton;

    @FXML
    void handleAddPlayerButton(ActionEvent event) throws IOException {
    	filename = "addPlayer";
    	loadNewPage(filename, event);
    }

    @FXML
    void handleExitButton(ActionEvent event) {
    	Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();    }

    @FXML
    void handleSearchClubButton(ActionEvent event) throws IOException {
    	filename = "clubMaxSalary";
    	loadNewPage(filename, event);
    }

    @FXML
    void handleSearchPlayerButton(ActionEvent event) throws IOException {
    	filename = "searchByPlayerName";
    	loadNewPage(filename, event);
    }
    
    public void loadNewPage(String filename, ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource(filename + ".fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
	}
    

}
