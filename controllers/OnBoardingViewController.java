package controllers;


import javafx.stage.*;
import models.*;
import views.OnBoardingView;

import java.io.IOException;

import javafx.event.*;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;


public class OnBoardingViewController extends Stage {

	public OnBoardingView onBoardingView = new OnBoardingView();
	public Stage directedDashboard = new Stage();
	

	public OnBoardingViewController(StageStyle style) {
		super(style);

		setScene(onBoardingView);

		setTitle("Restaurant Reservation System");
		setResizable(false);
		setupEventHandlers();

	}

	private void setupEventHandlers() {
		onBoardingView.loginButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				SystemUser authenticatedUser = Restaurant.mainRestaurant.authenticate(onBoardingView.usernameField.getText(), onBoardingView.passwordField.getText());
				if (authenticatedUser != null) {
					if (authenticatedUser.role.equals(SystemUserRole.CLIENT)) {
						System.out.print("Client");
						try {
							directedDashboard.setScene(new Scene(FXMLLoader.load(getClass().getResource("/views/ClientDashBoardView.fxml")), 700, 700));
							directedDashboard.setMaximized(true);
							directedDashboard.show();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						
					} else if (authenticatedUser.role.equals(SystemUserRole.MANAGER)) {
						
					} else if (authenticatedUser.role.equals(SystemUserRole.WAITER)) {
						
					} else {
						// CHEF
					}
				
					OnBoardingViewController.this.close();
					
				} else {
					Restaurant.showAlert(AlertType.ERROR, "Authentication Failed", "Incorrect username or password.", null);
				}
			}
		});
	}




}
