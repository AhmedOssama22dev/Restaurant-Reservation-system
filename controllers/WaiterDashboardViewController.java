package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.*;
import javafx.stage.StageStyle;
import models.*;
import javafx.collections.*;

import views.WaiterDashboardView;

public class WaiterDashboardViewController extends Stage {

	public WaiterDashboardView waiterDashboardView = new WaiterDashboardView();
	private ObservableList<Reservation> reservations = FXCollections.observableArrayList();
	private SystemUser waiterUser;
	
	public SystemUser getWaiterUser() {
		return waiterUser;
	}

	public void setWaiterUser(SystemUser waiterUser) {
		this.waiterUser = waiterUser;
		this.waiterDashboardView.greetingLabel.setText("	Hi " + waiterUser.name + ",\n	RESERVATIONS TODAY");
	}

	public ObservableList<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(ObservableList<Reservation> reservations) {
		this.reservations = reservations;
		this.waiterDashboardView.tableView.setItems(reservations);
	}

	public WaiterDashboardViewController(StageStyle style) {
		super(style);

		setScene(waiterDashboardView);

		setTitle("Waiter's Dashboard");
		setResizable(false);
		setupEventHandlers();

	}

	private void setupEventHandlers() {
		
	}



}
