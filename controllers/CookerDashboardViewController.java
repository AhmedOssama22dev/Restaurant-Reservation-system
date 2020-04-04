package controllers;

import javafx.stage.*;
import javafx.stage.StageStyle;
import models.*;
import javafx.collections.*;

import views.CookerDashboardView;

public class CookerDashboardViewController extends Stage {
	
	public CookerDashboardView cookerDashboardView = new CookerDashboardView();
	private ObservableList<OrderedMeal> orderedMeals = FXCollections.observableArrayList();
	private SystemUser cookerUser;
	
	public SystemUser getWaiterUser() {
		return cookerUser;
	}

	public void setCookerUser(SystemUser cookerUser) {
		this.cookerUser = cookerUser;
		this.cookerDashboardView.greetingLabel.setText("	Hi " + cookerUser.name + ",\n	MEALS ORDERED TODAY");
	}

	public ObservableList<OrderedMeal> getOrderedMeals() {
		return orderedMeals;
	}

	public void setOrderedMeals(ObservableList<OrderedMeal> orderedMeals) {
		this.orderedMeals = orderedMeals;
		this.cookerDashboardView.tableView.setItems(orderedMeals);
	}

	public CookerDashboardViewController(StageStyle style) {
		super(style);

		setScene(cookerDashboardView);

		setTitle("Cooker's Dashboard");
		setResizable(false);
		setupEventHandlers();

	}

	private void setupEventHandlers() {
		
	}


}
