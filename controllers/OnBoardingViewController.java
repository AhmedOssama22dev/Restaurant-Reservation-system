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
	
	public ClientDashBoardController clientDashboard;
	public WaiterDashboardViewController waiterDashboard;
	public CookerDashboardViewController cookerDashboard;
	public ManagerDashboardViewController managerDashboard;

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

							if (clientDashboard == null) {
								clientDashboard = new ClientDashBoardController();
								clientDashboard.setScene(new Scene(FXMLLoader.load(getClass().getResource("/views/ClientDashBoardView.fxml")), 910, 577));
								clientDashboard.setTitle("Client Dashboard");
								clientDashboard.setClientUser(authenticatedUser);
								clientDashboard.setResizable(false);
								clientDashboard.setMaximized(false);
								clientDashboard.setOnCloseRequest(new EventHandler<WindowEvent>() {
	                                 public void handle(WindowEvent we) {
	                                	   OnBoardingViewController.this.show();
	                                	   clientDashboard.close();
	                                 }
								});
							}

							clientDashboard.show();

						} catch (Exception e1) {
							e1.printStackTrace();
						}

					} else if (authenticatedUser.role.equals(SystemUserRole.MANAGER)) {
						
						if (managerDashboard == null) {
							managerDashboard = new ManagerDashboardViewController(StageStyle.DECORATED);
							managerDashboard.setResizable(false);
							managerDashboard.setMaximized(false);
							managerDashboard.setOrderedMeals(Restaurant.mainRestaurant.fetchOrderedMeals());
							managerDashboard.setSystemUsers(Restaurant.mainRestaurant.fetchSystemUsers());
							managerDashboard.setReservations(Restaurant.mainRestaurant.fetchReservations());
							managerDashboard.setCheckouts(Restaurant.mainRestaurant.fetchCheckouts());
							managerDashboard.setManagerUser(authenticatedUser);
							managerDashboard.setOnCloseRequest(new EventHandler<WindowEvent>() {
	                                 public void handle(WindowEvent we) {
	                                	   OnBoardingViewController.this.show();
	                                	   managerDashboard.close();
	                                 }
	                        });
						}

						managerDashboard.show();
						
					} else if (authenticatedUser.role.equals(SystemUserRole.WAITER)) {

						if (waiterDashboard == null) {
							waiterDashboard = new WaiterDashboardViewController(StageStyle.DECORATED);
							waiterDashboard.setResizable(false);
							waiterDashboard.setMaximized(false);
							waiterDashboard.setReservations(Restaurant.mainRestaurant.fetchReservations());
							waiterDashboard.setWaiterUser(authenticatedUser);
							waiterDashboard.setOnCloseRequest(new EventHandler<WindowEvent>() {
	                                 public void handle(WindowEvent we) {
	                                	   OnBoardingViewController.this.show();
	                                	   waiterDashboard.close();
	                                 }
	                        });
						}

						waiterDashboard.show();

					} else {

						if (cookerDashboard == null) {
							cookerDashboard = new CookerDashboardViewController(StageStyle.DECORATED);
							cookerDashboard.setResizable(false);
							cookerDashboard.setMaximized(false);
							cookerDashboard.setOrderedMeals(Restaurant.mainRestaurant.fetchOrderedMeals());
							cookerDashboard.setCookerUser(authenticatedUser);
							cookerDashboard.setOnCloseRequest(new EventHandler<WindowEvent>() {
	                                 public void handle(WindowEvent we) {
	                                	   OnBoardingViewController.this.show();
	                                	   cookerDashboard.close();
	                                 }
	                        });
						}

						cookerDashboard.show();
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
