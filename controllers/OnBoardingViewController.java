package controllers;


import javafx.stage.*;
import models.*;
import views.OnBoardingView;
import javafx.event.*;


public class OnBoardingViewController extends Stage {

	public OnBoardingView onBoardingView = new OnBoardingView();


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
					System.out.print("Logged In Dashboard: " + authenticatedUser.role.toString());
				}
			}

		});
	}




}
