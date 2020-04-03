package views;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import java.io.*;
import javafx.scene.text.*;
import javafx.scene.image.*;

public class OnBoardingView extends Scene {

	public static HBox hStack = new HBox();
	
	public StackPane leftPane = new StackPane();
	
	public VBox leftVStack = new VBox();
	public VBox rightVStack = new VBox();
	
	public ImageView splashImage = new ImageView();
	
	public Label titleLabel = new Label("Restaurant Management System");
	public Label managersLabel = new Label("Managers, view all tables, waiters and\n" + 
			"chefs of the restaurant and get access to in-detail analytics.");
	public Label clientsLabel = new Label("Clients, view the restaurant"
			+ "s menu, available\n tables, make orders and reservations.");
	public Label waitersLabel = new Label("Waiters, view todays reservations.");
	public Label chefsLabel = new Label("Chefs, view todays ordered meals.");

	public Label welcomeLabel = new Label("Welcome Back");
	public Label promptLabel = new Label("Provide the username and password to access dashboard.");
	
	public TextField usernameField = new TextField();
	public PasswordField passwordField = new PasswordField();
	
	public Button loginButton = new Button("Login");
	public Button closeButton = new Button("Dismiss");

	
	public OnBoardingView() {
		super(hStack, 800, 480);
		setupView();
		setFill(Color.BLACK);
	}

	private void setupView() {		
		try {
			Image image = new Image(new FileInputStream("OnBoardingImage.png"));
			splashImage.setImage(image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	    titleLabel.setTextFill(Color.web("#f8f8ff"));
	    titleLabel.setFont(new Font(28));
	    
	    managersLabel.setTextFill(Color.web("#f8f8ff"));
	    managersLabel.setFont(new Font(15));
	    
	    clientsLabel.setTextFill(Color.web("#f8f8ff"));
	    clientsLabel.setFont(new Font(15));
	    
	    waitersLabel.setTextFill(Color.web("#f8f8ff"));
	    waitersLabel.setFont(new Font(15));
	    
	    chefsLabel.setTextFill(Color.web("#f8f8ff"));
	    chefsLabel.setFont(new Font(15));

	    welcomeLabel.setTextFill(Color.web("#f8f8ff"));
	    welcomeLabel.setAlignment(Pos.TOP_RIGHT);
	    welcomeLabel.setFont(new Font(25));
	    
	    promptLabel.setTextFill(Color.web("#f8f8ff"));
	    promptLabel.setFont(new Font(15));
	    promptLabel.setMinWidth(250);
	    promptLabel.setWrapText(true);
	    
	    usernameField.setPromptText("USERNAME");
	    passwordField.setPromptText("PASSWORD");
	    
		leftVStack.getChildren().addAll(titleLabel, managersLabel, clientsLabel, waitersLabel, chefsLabel);
		leftVStack.setAlignment(Pos.TOP_LEFT);
		leftVStack.setPadding(new Insets(30, 30, 0, 60));
		leftVStack.setSpacing(30);
		
		rightVStack.setStyle("-fx-background-color: rgba(0, 0, 0, 1.0);");
		rightVStack.getChildren().addAll(welcomeLabel, promptLabel, usernameField, passwordField, loginButton, closeButton);
		rightVStack.setAlignment(Pos.TOP_CENTER);
		rightVStack.setSpacing(30);
	    rightVStack.setPadding(new Insets(30, 30, 0, 30));
	    
		leftPane.getChildren().addAll(splashImage, leftVStack);
		hStack.getChildren().addAll(leftPane, rightVStack);
	}
	
}
