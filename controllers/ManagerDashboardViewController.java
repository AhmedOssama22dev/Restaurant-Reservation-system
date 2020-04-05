package controllers;

import javafx.stage.*;
import javafx.stage.StageStyle;
import models.*;
import javafx.collections.*;
import views.ManagerDashboardView;
import javafx.animation.*;
import javafx.util.*;
import javafx.event.*;
;


public class ManagerDashboardViewController extends Stage {
	
	public ManagerDashboardView managerDashboardView = new ManagerDashboardView();
 	private ObservableList<OrderedMeal> orderedMeals = FXCollections.observableArrayList();
	private ObservableList<Reservation> reservations = FXCollections.observableArrayList();
	private ObservableList<SystemUser>  systemUsers = FXCollections.observableArrayList();
	private ObservableList<Check>  checkouts = FXCollections.observableArrayList();	

	private SystemUser managerUser;
	
	
	public SystemUser getManagerUser() {
		return managerUser;
	}
	
	public void setManagerUser(SystemUser managerUser) {
		this.managerUser = managerUser;
		this.managerDashboardView.greetingLabel.setText("	Hi " + managerUser.name + ",\n	SYSTEM USERS");
	}
	
	public ObservableList<OrderedMeal> getOrderedMeals() {
		return orderedMeals;
	}

	public void setOrderedMeals(ObservableList<OrderedMeal> orderedMeals) {
		this.orderedMeals = orderedMeals;
		this.managerDashboardView.orderedMealsTableView.setItems(orderedMeals);
	}
	
	public ObservableList<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(ObservableList<Reservation> reservations) {
		this.reservations = reservations;
		this.managerDashboardView.reservationsTableView.setItems(reservations);
	}
	
	public ObservableList<SystemUser> getSystemUsers() {
		return systemUsers;
	}

	public void setSystemUsers(ObservableList<SystemUser> systemUsers) {
		this.systemUsers = systemUsers;
		this.managerDashboardView.systemUsersTableView.setItems(systemUsers);
	}
	
	public ObservableList<Check> getCheckouts() {
		return checkouts;
	}

	public void setCheckouts(ObservableList<Check> checkouts) {
		this.checkouts = checkouts;
		this.managerDashboardView.checksTableView.setItems(checkouts);
	}
	
	public ManagerDashboardViewController(StageStyle style) {
		super(style);

		setScene(managerDashboardView);

		setTitle("Manager's Dashboard");
		setResizable(false);
		setupEventHandlers();
	}

	private void setupEventHandlers() {
		managerDashboardView.systemUsersModeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
            	managerDashboardView.greetingLabel.setText("	Hi " + managerUser.name + ",\n	SYSTEM USERS");
            	
                FadeTransition transition = new FadeTransition(Duration.seconds(1));
                transition.setFromValue(1.0);
                transition.setToValue(0.0);
                transition.setNode(managerDashboardView.borderLayout.getBottom());
                transition.play();

                transition.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        managerDashboardView.systemUsersTableView.setOpacity(0.0);
                        managerDashboardView.borderLayout.setBottom(managerDashboardView.systemUsersTableView);

                        FadeTransition newFade = new FadeTransition(Duration.seconds(0.7));
                        newFade.setFromValue(0.0);
                        newFade.setToValue(1.0);
                        newFade.setNode(managerDashboardView.borderLayout.getBottom());
                        newFade.play();
                    }
                });
            }
        });
		
		
		managerDashboardView.reservationsModeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
            	managerDashboardView.greetingLabel.setText("	Hi " + managerUser.name + ",\n	RESERVATIONS TODAY");
            	
                FadeTransition transition = new FadeTransition(Duration.seconds(1));
                transition.setFromValue(1.0);
                transition.setToValue(0.0);
                transition.setNode(managerDashboardView.borderLayout.getBottom());
                transition.play();

                transition.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        managerDashboardView.reservationsTableView.setOpacity(0.0);
                        managerDashboardView.borderLayout.setBottom(managerDashboardView.reservationsTableView);

                        FadeTransition newFade = new FadeTransition(Duration.seconds(0.7));
                        newFade.setFromValue(0.0);
                        newFade.setToValue(1.0);
                        newFade.setNode(managerDashboardView.borderLayout.getBottom());
                        newFade.play();
                    }
                });
            }
        });
		
		
		managerDashboardView.orderedMealsModeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
            	managerDashboardView.greetingLabel.setText("	Hi " + managerUser.name + ",\n	MEALS ORDERED TODAY");
            	
                FadeTransition transition = new FadeTransition(Duration.seconds(1));
                transition.setFromValue(1.0);
                transition.setToValue(0.0);
                transition.setNode(managerDashboardView.borderLayout.getBottom());
                transition.play();

                transition.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        managerDashboardView.orderedMealsTableView.setOpacity(0.0);
                        managerDashboardView.borderLayout.setBottom(managerDashboardView.orderedMealsTableView);

                        FadeTransition newFade = new FadeTransition(Duration.seconds(0.7));
                        newFade.setFromValue(0.0);
                        newFade.setToValue(1.0);
                        newFade.setNode(managerDashboardView.borderLayout.getBottom());
                        newFade.play();
                    }
                });
            }
        });
		
		
		managerDashboardView.analyticsModeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
            	managerDashboardView.greetingLabel.setText("	Hi " + managerUser.name + ",\n	CHECKS TODAY");
            	
                FadeTransition transition = new FadeTransition(Duration.seconds(1));
                transition.setFromValue(1.0);
                transition.setToValue(0.0);
                transition.setNode(managerDashboardView.borderLayout.getBottom());
                transition.play();

                transition.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        managerDashboardView.checksTableView.setOpacity(0.0);
                        managerDashboardView.borderLayout.setBottom(managerDashboardView.checksTableView);

                        FadeTransition newFade = new FadeTransition(Duration.seconds(0.7));
                        newFade.setFromValue(0.0);
                        newFade.setToValue(1.0);
                        newFade.setNode(managerDashboardView.borderLayout.getBottom());
                        newFade.play();
                    }
                });
            }
        });
	}
}
