package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	private Stage stage;
	
	public Stage getStage() {
		return stage;
	}
	
	public static void main(String[] args) throws Exception {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("home.fxml"));
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("HOME");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	
}
