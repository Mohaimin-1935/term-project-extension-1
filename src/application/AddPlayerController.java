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

public class AddPlayerController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML private Button backToHome;
    @FXML private TextField name;
    @FXML private TextField country;
    @FXML private TextField salary;
    @FXML private TextField position;
    @FXML private TextField age;
    @FXML private TextField height;
    @FXML private TextField club;
    @FXML private TextField number;
    @FXML private Label error;
    @FXML private Label success;
    @FXML private Button addPlayer;

    @FXML
    void handleAddPlayer(ActionEvent event) {
    	PlayerDatabase allPlayerList = new PlayerDatabase();
        try {
			allPlayerList.list = FileOperation.readFromFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        error.setText(null);
        success.setText(null);
    	
    	Player p = new Player();
    	
    	if (name.getText()==null || name.getText().isEmpty()) {
    		error.setText("Name is required!");
    		return;
    	} else { p.setName(name.getText()); }
    	
    	if (country.getText()==null || country.getText().isEmpty()) {
    		error.setText("Country is required!");
    		return;
    	} else { p.setCountry(country.getText()); }
    	
    	if (age.getText()==null || age.getText().isEmpty()) {
    		error.setText("Age is required.");
    		return;
    	} else { 
    		try {
				Integer ageInt = Integer.parseInt(age.getText());
				if (ageInt > 0) {
					p.setAge(ageInt);
				} else {
					error.setText("Age should be a natural number");
					return;
				}
			} catch (Exception e) {
				error.setText("Age should be a natural number");
				return;
			}
    	}
    	
    	if (height.getText()==null || height.getText().isEmpty()) {
    		error.setText("Height is required.");
    		return;
    	} else { 
    		try {
				Double heightDouble = Double.parseDouble(height.getText());
				if (heightDouble > 0) {
					p.setHeight(heightDouble);
				} else {
					error.setText("Height should be a decimal number");
					return;
				}
			} catch (Exception e) {
				error.setText("Height should be a decimal number");
				return;
			}
    	}
    	
    	if (club.getText()==null || club.getText().isEmpty()) {
    		error.setText("Club is required.");
    		return;
    	} else { p.setPlayerClub(club.getText()); }
    	
    	if (position.getText()==null || position.getText().isEmpty()) {
    		error.setText("Position is required.");
    		return;
    	} else { p.setPosition(position.getText()); }
    	
    	if (salary.getText()==null || salary.getText().isEmpty()) {
    		error.setText("Weekly Salary is required.");
    		return;
    	} else { 
    		try {
				Double salaryDouble = Double.parseDouble(salary.getText());
				if (salaryDouble > 0) {
					p.setWeeklySalary(salaryDouble);
				} else {
					error.setText("Salary should be a decimal number");
					return;
				}
			} catch (Exception e) {
				error.setText("Salary should be a decimal number");
				return;
			}
    	}
    	
    	if (number.getText()==null || number.getText().isEmpty()) {
    		error.setText("Number is required.");
    		return;
    	} else { 
    		try {
				Integer numberInt = Integer.parseInt(number.getText());
				if (numberInt > 0) {
					p.setNumber(numberInt);
				} else {
					error.setText("Number should be a natural number");
					return;
				}
			} catch (Exception e) {
				error.setText("Number should be a natural number");
				return;
			}
    	}

        int status = allPlayerList.addPlayerToDatabase(p);
        if (status > 0) {
        	success.setText("Player added successfully.");
        	showAlert();
        	return;
        } else {
        	if (status == -1) {
        		error.setText("A player with this name already exists.");
        	} else if (status == -2) {
        		error.setText("Already 7 players exist in this club");
        	} else {
        		error.setText("An unknown error occured.");
        	}
        }
    }
    
    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Success");
        alert.setHeaderText("Success");
        alert.setContentText("Player added successfully to database.");
        alert.showAndWait();
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
