package views;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class OnBoardingView extends Scene {

	public static HBox horizontalStack = new HBox();
	public Label l = new Label("Hello, World!"); 
	
	public OnBoardingView() {
		super(horizontalStack, 800, 480);
		setupView();
	}

	private void setupView() {		
		horizontalStack.getChildren().add(l);
	}
	
}
