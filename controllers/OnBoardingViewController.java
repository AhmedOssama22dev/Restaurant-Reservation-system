package controllers;


import javafx.stage.*;
import views.OnBoardingView;

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
		onBoardingView.sampleButton.setOnAction(actionEvent ->  {
			onBoardingView.sampleLabel.setText("Ahmed Ossama");			
		});;
	}

}
