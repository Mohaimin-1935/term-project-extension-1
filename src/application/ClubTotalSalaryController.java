package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClubTotalSalaryController {
	
	private String fileName;
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML private Button maxSalary;
    @FXML private Button maxAge;
    @FXML private Button maxHeight;
    @FXML private Button totalSalary;
    @FXML private Button backToHome;
    @FXML private TextField clubQuery;
    @FXML private Button submitButton;
    @FXML private Label resultDesc;
    @FXML private Label result;

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
    
    @FXML
    void handleSubmit(ActionEvent event) {
    	
    	PlayerDatabase allPlayerList = new PlayerDatabase();
        try {
			allPlayerList.list = FileOperation.readFromFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        double total = allPlayerList.totalYearlySalaryOfClub(clubQuery.getText());
        if (total < 0) {
        	showAlert();
        } else {
            result.setText("$" + String.format("%.0f\n", total));
            resultDesc.setText("The total yearly income of " + clubQuery.getText() + " is: ");
        } 
        
    }
    
    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Not Found");
        alert.setHeaderText("Not Found");
        alert.setContentText("There was no club found with your query.");
        alert.showAndWait();
    }
    
    public void loadNewPage(String fileName, ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource(fileName + ".fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

}
