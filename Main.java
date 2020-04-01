import models.*;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.lang.model.element.Element;
import javax.swing.plaf.RootPaneUI;

import controllers.ClientDashBoardController;
import controllers.OnBoardingViewController;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.*;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage = new OnBoardingViewController(StageStyle.UNDECORATED);
		primaryStage.show();
		//showing clientDashBoard
		Stage s=new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/views/ClientDashBoardView.fxml"));
		ClientDashBoardController clientDashBoardController = new ClientDashBoardController();
		clientDashBoardController.setupEvents();
		s.setScene(new Scene(root, 700, 700));
		s.setMaximized(true);
		s.show();

    }
}
