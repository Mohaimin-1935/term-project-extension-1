package application;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ClubMaxHeightController implements Initializable {
	
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
    @FXML private TableView<Player> playerList;
    @FXML private TableColumn<Player, String> nameField;
    @FXML private TableColumn<Player, String> countryField;
    @FXML private TableColumn<Player, Integer> ageField;
    @FXML private TableColumn<Player, Double> heightField;
    @FXML private TableColumn<Player, String> clubField;
    @FXML private TableColumn<Player, String> positionField;
    @FXML private TableColumn<Player, Double> salaryField;
    @FXML private TableColumn<Player, Integer> numberField;

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
    	playerList.getItems().clear();
    	
    	PlayerDatabase allPlayerList = new PlayerDatabase();
        try {
			allPlayerList.list = FileOperation.readFromFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        List<Player> queryResponse = allPlayerList.playerWithMaxHeightInClub(clubQuery.getText());
        
        if (queryResponse.isEmpty()) { showAlert(); }
        
        for (Player p: queryResponse) {
			players.add(p);
		}
        
        playerList.setItems(players);
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
    
    private ObservableList<Player> players = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nameField.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		countryField.setCellValueFactory(new PropertyValueFactory<Player, String>("country"));
		ageField.setCellValueFactory(new PropertyValueFactory<Player, Integer>("age"));
		heightField.setCellValueFactory(new PropertyValueFactory<Player, Double>("height"));
		clubField.setCellValueFactory(new PropertyValueFactory<Player, String>("playerClub"));
		positionField.setCellValueFactory(new PropertyValueFactory<Player, String>("position"));
		salaryField.setCellValueFactory(new PropertyValueFactory<Player, Double>("weeklySalary"));
		numberField.setCellValueFactory(new PropertyValueFactory<Player, Integer>("number"));
		
		playerList.setItems(players);
		
	}

}
