package views;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.cell.*;
import javafx.scene.text.*;
import models.*;

public class CookerDashboardView extends Scene {
	
	public static VBox vStack = new VBox();
	
	public Label greetingLabel = new Label("Hi Chef,\nMEALS ORDERED TODAY");

	public TableView<OrderedMeal> tableView = new TableView<OrderedMeal>();
    private TableColumn<OrderedMeal, String> clientName = new TableColumn<OrderedMeal, String>("Client Name");
    private TableColumn<OrderedMeal, Boolean> tableNumber = new TableColumn<OrderedMeal, Boolean>("Table Number");
    private TableColumn<OrderedMeal, Integer> mealCategory = new TableColumn<OrderedMeal, Integer>("Meal Category");
    private TableColumn<OrderedMeal, Integer> mealName = new TableColumn<OrderedMeal, Integer>("Meal Name");
	
	public CookerDashboardView() {
		super(vStack, 450, 550);
		setupView();
		setFill(Color.BLACK);
	}

	private void setupView() {
		
		
		tableView.setPlaceholder(new Label("NO ORDERED MEALS"));
        tableView.getColumns().addAll(clientName, tableNumber, mealCategory, mealName);
        
        greetingLabel.setFont(new Font(30));
        greetingLabel.setTextFill(Color.web("#f8f8ff"));
        greetingLabel.setAlignment(Pos.CENTER);

        
        clientName.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
        clientName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        
        tableNumber.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
        tableNumber.setCellValueFactory(new PropertyValueFactory<>("tableNumber"));
        
        mealCategory.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
        mealCategory.setCellValueFactory(new PropertyValueFactory<>("dishCategory"));
        
        mealName.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
        mealName.setCellValueFactory(new PropertyValueFactory<>("dishName"));
        

		vStack.setAlignment(Pos.TOP_LEFT);
		vStack.setSpacing(45);
		vStack.setPadding(new Insets(30, 0, 10, 0));
		vStack.setStyle("-fx-background-color: rgba(0, 0, 0, 1.0);");
		vStack.getChildren().addAll(greetingLabel, tableView);
	}
}
