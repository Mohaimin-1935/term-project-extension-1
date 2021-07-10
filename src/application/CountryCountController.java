package application;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
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

public class CountryCountController implements Initializable {

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
    @FXML private TextField countryQuery;
    @FXML private TableView<CountryCount> countryCountTable;
    @FXML private TableColumn<CountryCount, String> countryField;
    @FXML private TableColumn<CountryCount, Integer> countField;


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
    
    private ObservableList<CountryCount> countryCounts = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	countryField.setCellValueFactory(new PropertyValueFactory<CountryCount, String>("country"));
    	countField.setCellValueFactory(new PropertyValueFactory<CountryCount, Integer>("count"));
    	
    	PlayerDatabase allPlayerList = new PlayerDatabase();
    	try {
			allPlayerList.list = FileOperation.readFromFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	Map<String,Integer> countryFrequency = allPlayerList.countryCount();
        for (String country: countryFrequency.keySet()) {
            countryCounts.add(new CountryCount(country, countryFrequency.get(country)));
        }
        
        FilteredList<CountryCount> filteredList = new FilteredList<>(countryCounts, c -> true);
		
		countryQuery.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredList.setPredicate(c -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (c.getCountry().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				return false;
			});
		});
		
		SortedList<CountryCount> sortedList = new SortedList<>(filteredList);
		
		sortedList.comparatorProperty().bind(countryCountTable.comparatorProperty());
        
        countryCountTable.setItems(sortedList);
    	
    	
    }

}

