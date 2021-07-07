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

public class SearchByPlayerNameController {

	private String fileName;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
    @FXML
    private Button playerName;

    @FXML
    private Button clubAndCountry;

    @FXML
    private Button position;

    @FXML
    private Button salaryRange;

    @FXML
    private Button countryCount;

    @FXML
    private Button backToHome;

    @FXML
    void handleBackToHome(ActionEvent event) throws IOException {
    	fileName = "home";
    	loadNewPage(fileName, event);
    }

    @FXML
    void handleCountryCount(ActionEvent event) throws IOException {
    	fileName = "countryCount";
    	loadNewPage(fileName, event);
    }

    @FXML
    void handleSearchByClubAndCountry(ActionEvent event) throws IOException {
    	fileName = "searchByClubAndCountry";
    	loadNewPage(fileName, event);
    }

    @FXML
    void handleSearchByPlayerName(ActionEvent event) throws IOException {
    	fileName = "searchByPlayerName";
    	loadNewPage(fileName, event);
    }

    @FXML
    void handleSearchByPosition(ActionEvent event) throws IOException {
    	fileName = "searchByPosition";
    	loadNewPage(fileName, event);
    }

    @FXML
    void handleSearchBySalaryRange(ActionEvent event) throws IOException {
    	fileName = "searchBySalaryRange";
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
