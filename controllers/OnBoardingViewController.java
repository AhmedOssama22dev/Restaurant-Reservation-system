package controllers;


import javafx.stage.*;
import models.*;
import views.OnBoardingView;

import javafx.event.*;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import controllers.*;


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

						try {
							directedDashboard.setScene(new Scene(FXMLLoader.load(getClass().getResource("/views/ClientDashBoardView.fxml")), 1351, 705));
							directedDashboard.setTitle("Client Dashboard");
							directedDashboard.setResizable(false);
							directedDashboard.setMaximized(false);
							directedDashboard.show();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						
					} else if (authenticatedUser.role.equals(SystemUserRole.MANAGER)) {
						
					} else if (authenticatedUser.role.equals(SystemUserRole.WAITER)) {
						
						WaiterDashboardViewController dashboard = new WaiterDashboardViewController(StageStyle.DECORATED);
						dashboard.setResizable(false);
						dashboard.setMaximized(false);
						dashboard.setReservations(Restaurant.mainRestaurant.fetchReservations());
						dashboard.setWaiterUser(authenticatedUser);
						dashboard.setOnCloseRequest(new EventHandler<WindowEvent>() {
                                 public void handle(WindowEvent we) {
                                	 OnBoardingViewController.this.show();
                                	 directedDashboard = null;
                                 }
                        });
						
						directedDashboard = dashboard;
						directedDashboard.show();
						
					} else {
						// CHEF
					}
				
					OnBoardingViewController.this.close();
					
				} else {
					Restaurant.showAlert(AlertType.ERROR, "Authentication Failed", "Incorrect username or password.", null);
				}
			}
		});
		
		onBoardingView.closeButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				OnBoardingViewController.this.close();
			}
		});
	}




}
