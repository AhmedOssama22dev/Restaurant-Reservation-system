package views;

import javafx.geometry.*;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import models.*;

public class ManagerDashboardView extends Scene {
		
    public static BorderPane borderLayout = new BorderPane();

    public ToolBar toolBar = new ToolBar();
    public Button systemUsersModeButton = new Button("Users");
    public Button reservationsModeButton = new Button("Reservations");
    public Button orderedMealsModeButton = new Button("Ordered Meals");
    public Button analyticsModeButton = new Button("Checkouts");

	public Label greetingLabel = new Label("Hi Manager,\nMEALS ORDERED TODAY");
    
	public TableView<SystemUser> systemUsersTableView = new TableView<SystemUser>();
    private TableColumn<SystemUser, String> systemUserName = new TableColumn<SystemUser, String>("Name");
    private TableColumn<SystemUser, String> systemUserRole = new TableColumn<SystemUser, String>("Role");

    public TableView<Reservation> reservationsTableView = new TableView<Reservation>();
    private TableColumn<Reservation, String> clientName = new TableColumn<Reservation, String>("Reserver's Name");
    private TableColumn<Reservation, Integer> tableNumber = new TableColumn<Reservation, Integer>("Table Number");
    private TableColumn<Reservation, Integer> seatsCount = new TableColumn<Reservation, Integer>("Seats Count");
    private TableColumn<Reservation, Boolean> isSmoking = new TableColumn<Reservation, Boolean>("Is Smoking");
    
    public TableView<OrderedMeal> orderedMealsTableView = new TableView<OrderedMeal>();
    private TableColumn<OrderedMeal, String> reserverName = new TableColumn<OrderedMeal, String>("Client Name");
    private TableColumn<OrderedMeal, Boolean> tableNum = new TableColumn<OrderedMeal, Boolean>("Table Number");
    private TableColumn<OrderedMeal, Integer> mealCategory = new TableColumn<OrderedMeal, Integer>("Meal Category");
    private TableColumn<OrderedMeal, Integer> mealName = new TableColumn<OrderedMeal, Integer>("Meal Name");
    private TableColumn<OrderedMeal, Integer> mealPrice = new TableColumn<OrderedMeal, Integer>("Meal Price");

    
    public TableView<Check> checksTableView = new TableView<Check>();
    private TableColumn<Check, Integer> tableNumb = new TableColumn<Check, Integer>("Table Number");
    private TableColumn<Check, Integer> totalAmount = new TableColumn<Check, Integer>("Total Amount");

    
	public ManagerDashboardView() {
		super(borderLayout, 780, 650);
		setupView();
		setFill(Color.BLACK);
	}

	private void setupView() {
		
		Region spacer = new Region();
	    spacer.setMinWidth(Region.USE_PREF_SIZE);	HBox.setHgrow(spacer, Priority.ALWAYS);
	    
	    systemUsersTableView.setPlaceholder(new Label("NO SYSTEM USERS"));
	    systemUsersTableView.getColumns().addAll(systemUserName, systemUserRole);
	    
	    systemUserName.prefWidthProperty().bind(systemUsersTableView.widthProperty().multiply(0.5));
	    systemUserName.setCellValueFactory(new PropertyValueFactory<>("name"));
        
	    systemUserRole.prefWidthProperty().bind(systemUsersTableView.widthProperty().multiply(0.5));
	    systemUserRole.setCellValueFactory(new PropertyValueFactory<>("role"));
	    
	    reservationsTableView.setPlaceholder(new Label("NO RESERVATIONS"));
	    reservationsTableView.getColumns().addAll(clientName, tableNumber, seatsCount, isSmoking);
	    
	    clientName.prefWidthProperty().bind(reservationsTableView.widthProperty().multiply(0.25));
        clientName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        
        tableNumber.prefWidthProperty().bind(reservationsTableView.widthProperty().multiply(0.25));
        tableNumber.setCellValueFactory(new PropertyValueFactory<>("tableNumber"));
        
        seatsCount.prefWidthProperty().bind(reservationsTableView.widthProperty().multiply(0.25));
        seatsCount.setCellValueFactory(new PropertyValueFactory<>("seatsCount"));
        
        isSmoking.prefWidthProperty().bind(reservationsTableView.widthProperty().multiply(0.25));
        isSmoking.setCellValueFactory(new PropertyValueFactory<>("isSmokingTable"));
	    

	    orderedMealsTableView.setPlaceholder(new Label("NO ORDERED MEALS"));
	    orderedMealsTableView.getColumns().addAll(reserverName, tableNum, mealCategory, mealName, mealPrice);
	    
	    reserverName.prefWidthProperty().bind(orderedMealsTableView.widthProperty().multiply(0.2));
	    reserverName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
	        
	    tableNum.prefWidthProperty().bind(orderedMealsTableView.widthProperty().multiply(0.2));
	    tableNum.setCellValueFactory(new PropertyValueFactory<>("tableNumber"));
	        
	    mealCategory.prefWidthProperty().bind(orderedMealsTableView.widthProperty().multiply(0.2));
	    mealCategory.setCellValueFactory(new PropertyValueFactory<>("dishCategory"));
	        
	    mealName.prefWidthProperty().bind(orderedMealsTableView.widthProperty().multiply(0.2));
	    mealName.setCellValueFactory(new PropertyValueFactory<>("dishName"));
	    
	    mealPrice.prefWidthProperty().bind(orderedMealsTableView.widthProperty().multiply(0.2));
	    mealPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
	    
	    
	    checksTableView.setPlaceholder(new Label("NO CHECKOUTS"));
	    checksTableView.getColumns().addAll(tableNumb, totalAmount);
	    
	    tableNumb.prefWidthProperty().bind(checksTableView.widthProperty().multiply(0.5));
	    tableNumb.setCellValueFactory(new PropertyValueFactory<>("tableNumber"));
        
	    totalAmount.prefWidthProperty().bind(checksTableView.widthProperty().multiply(0.5));
	    totalAmount.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
	    
        greetingLabel.setFont(new Font(30));
        greetingLabel.setTextFill(Color.web("#f8f8ff"));
  
	    
        toolBar.getItems().addAll(systemUsersModeButton, spacer, reservationsModeButton, orderedMealsModeButton, analyticsModeButton);
		toolBar.setOrientation(Orientation.HORIZONTAL);
	
		borderLayout.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		borderLayout.setTop(toolBar);
		borderLayout.setCenter(greetingLabel);
		borderLayout.setBottom(systemUsersTableView);
	}
}
