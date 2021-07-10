package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SearchByPositionController implements Initializable {

	private String fileName;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
    @FXML private Button playerName;
    @FXML private Button clubAndCountry;
    @FXML private Button position;
    @FXML private Button salaryRange;
    @FXML private Button countryCount;
    @FXML private Button backToHome;   
    @FXML private TextField positionQuery;
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
    
	private ObservableList<Player> players = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		nameField.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		countryField.setCellValueFactory(new PropertyValueFactory<Player, String>("country"));
		ageField.setCellValueFactory(new PropertyValueFactory<Player, Integer>("age"));
		heightField.setCellValueFactory(new PropertyValueFactory<Player, Double>("height"));
		clubField.setCellValueFactory(new PropertyValueFactory<Player, String>("playerClub"));
		positionField.setCellValueFactory(new PropertyValueFactory<Player, String>("position"));
		salaryField.setCellValueFactory(new PropertyValueFactory<Player, Double>("weeklySalary"));
		numberField.setCellValueFactory(new PropertyValueFactory<Player, Integer>("number"));
		
		PlayerDatabase allPlayerList = new PlayerDatabase();
        try {
			allPlayerList.list = FileOperation.readFromFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Player p: allPlayerList.list) {
			players.add(p);
		}
		
		FilteredList<Player> filteredList = new FilteredList<>(players, p -> true);
		
		positionQuery.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredList.setPredicate(p -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (p.getPosition().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				return false;
			});
		});
		
		SortedList<Player> sortedList = new SortedList<>(filteredList);
		sortedList.comparatorProperty().bind(playerList.comparatorProperty());
		playerList.setItems(sortedList);
	}
	
}
