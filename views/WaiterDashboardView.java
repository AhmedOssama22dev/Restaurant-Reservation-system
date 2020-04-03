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

public class WaiterDashboardView extends Scene {

	public static VBox vStack = new VBox();
	
	public Label greetingLabel = new Label("Hi Waiter,\nRESERVATIONS TODAY");

	public TableView<Reservation> tableView = new TableView<Reservation>();
    private TableColumn<Reservation, String> clientName = new TableColumn<Reservation, String>("Reserver's Name");
    private TableColumn<Reservation, Integer> tableNumber = new TableColumn<Reservation, Integer>("Table Number");
    private TableColumn<Reservation, Integer> seatsCount = new TableColumn<Reservation, Integer>("Seats Count");
    private TableColumn<Reservation, Boolean> isSmoking = new TableColumn<Reservation, Boolean>("Is Smoking");
	
	public WaiterDashboardView() {
		super(vStack, 450, 550);
		setupView();
		setFill(Color.BLACK);
	}

	private void setupView() {
		
		
		tableView.setPlaceholder(new Label("NO RESERVATIONS"));
        tableView.getColumns().addAll(clientName, tableNumber, seatsCount, isSmoking);
        
        greetingLabel.setFont(new Font(30));
        greetingLabel.setTextFill(Color.web("#f8f8ff"));
        greetingLabel.setAlignment(Pos.CENTER);

        
        clientName.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
        clientName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        
        tableNumber.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
        tableNumber.setCellValueFactory(new PropertyValueFactory<>("tableNumber"));
        
        seatsCount.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
        seatsCount.setCellValueFactory(new PropertyValueFactory<>("seatsCount"));
        
        isSmoking.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
        isSmoking.setCellValueFactory(new PropertyValueFactory<>("isSmokingTable"));
        
		vStack.setAlignment(Pos.TOP_LEFT);
		vStack.setSpacing(45);
		vStack.setPadding(new Insets(30, 0, 10, 0));
		vStack.setStyle("-fx-background-color: rgba(0, 0, 0, 1.0);");
		vStack.getChildren().addAll(greetingLabel, tableView);
	}
	
}
