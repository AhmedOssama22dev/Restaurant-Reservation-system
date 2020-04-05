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

    }
}
