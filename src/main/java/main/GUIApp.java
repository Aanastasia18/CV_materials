package main;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

import controllers.ProfileController;
import domain.User;
import exceptions.UserExceptions;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GUIApp extends Application {

	
	/////////////// BOOT ///////////////////////////////
	 @SuppressWarnings("deprecation")
	@Override
	    public void start(Stage stage) throws UserExceptions, IOException {
		 
		 
		 FXMLLoader loader = new FXMLLoader();
		 URL xmlUrl = getClass().getResource("/profile-contact.fxml");
		 
		 loader.setLocation(xmlUrl);
		 Parent root = loader.load();
		 
		 // 1. load user
		 User u = new User();
		 u.setUserName("John");
		 u.setAvatarURL("/avatars/avatar-1-small.png");
		 u.setLastOnline(new Date(2021, 01, 10));
		 u.setEmail("aaa@gmail.com");
		 
		 // 2.Pass to controller
		 ((ProfileController)loader.getController()).setUser(u);		 

		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show(); 
		 
		 
		 
//	        String javaVersion = System.getProperty("java.version");
//	        String javafxVersion = System.getProperty("javafx.version");
//	        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//	        Scene scene = new Scene(new StackPane(l), 640, 480);
//	        stage.setScene(scene);
//	        stage.show();
	    }
	/////////////// BOOT ///////////////////////////////

	    public static void main(String[] args) {
	        launch();
	        
	    }

	    
	    // main() -----> launch() -----------> start()
 	
}
