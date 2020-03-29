package views;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class OnBoardingView extends Scene {

	public static HBox horizontalStack = new HBox();
	public Label sampleLabel = new Label("Hello, World!");
	public Button sampleButton = new Button("Hit Me!");
	
	public OnBoardingView() {
		super(horizontalStack, 800, 480);
		setupView();
	}

	private void setupView() {		
		
		horizontalStack.getChildren().addAll(sampleLabel, sampleButton);
	}
	
}
