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

public class ClubTotalSalaryController {
	
	private String fileName;
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private Button maxSalary;

    @FXML
    private Button maxAge;

    @FXML
    private Button maxHeight;

    @FXML
    private Button totalSalary;

    @FXML
    private Button backToHome;

    @FXML
    void handleBackToHome(ActionEvent event) throws IOException {
    	fileName = "home";
    	loadNewPage(fileName, event);
    }

    @FXML
    void handleMaxAge(ActionEvent event) throws IOException {
    	fileName = "clubMaxAge";
    	loadNewPage(fileName, event);
    }

    @FXML
    void handleMaxHeight(ActionEvent event) throws IOException {
    	fileName = "clubMaxHeight";
    	loadNewPage(fileName, event);
    }

    @FXML
    void handleMaxSalary(ActionEvent event) throws IOException {
    	fileName = "clubMaxSalary";
    	loadNewPage(fileName, event);
    }

    @FXML
    void handleTotalSalary(ActionEvent event) throws IOException {
    	fileName = "clubTotalSalary";
    	loadNewPage(fileName, event);
    }
    
    public void loadNewPage(String fileName, ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource(fileName + ".fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

}
