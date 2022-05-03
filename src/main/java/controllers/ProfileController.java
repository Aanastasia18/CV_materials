package controllers;

import java.util.Date;

import domain.User;
import exceptions.UserExceptions;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class ProfileController {
	
	private User user;

	@FXML
	private VBox root;

	@FXML
	private Label userName;
	
	@FXML
	private ImageView avatar;
	
	@FXML
	private Label email;
	
	@FXML
	private Label status;
	
	@FXML
	private Circle online;
	
	@FXML
	private VBox details;

	
	public void setUser(User user){
		this.user = user;
		
		renderCompact();
	}
	
	
	public void renderCompact() {
		
		avatar.setImage(new Image( getClass().getResourceAsStream(user.getAvatarURL())));
		userName.setText(user.getUserName());
		status.setText(user.onlineTimeAgo(user.getLastOnline()));
		
		if(user.isOnline(user.getLastOnline())) {
			online.setFill(Paint.valueOf("green"));
		} else {
			online.setFill(Paint.valueOf("grey"));
		}
		
		// hide and collapse
		details.setVisible(false);
		root.maxHeight(150);
		
		
		
//		User user = new User();
//			 user.setUserName("Johny777");
//			 
//			 labelUsername.setText(user.getUserName());
		
	}
	
	public void renderDetailed() {
		
		renderCompact();
		
		details.setVisible(true);
		root.maxHeight(300);
		email.setText(user.getEmail());
		user.setAvatarURL("/avatars/avatar-1-medium.png");
		
	}
	
	public void closeRenderDetailed() {
		user.setAvatarURL("/avatars/avatar-1-small.png");
		renderCompact();
		
	}
//	public void viewDetails() {
//		userName.setText(user.getUserName());
//		avatar.setImage(new Image( getClass().getResourceAsStream(user.getAvatarURL())));
//		
//		
//		
//	}
	
}
