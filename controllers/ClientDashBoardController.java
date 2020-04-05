package controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.*;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.net.URL;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import models.*;


public class ClientDashBoardController extends Stage implements Initializable{

	ObservableList<String> list = FXCollections.observableArrayList("Table 1 [5 seats]","Table 2 [12 seats]","Table 3 [12 seats]","Table 4 [4 seats]","Table 5 [4 seats]","Table 6 [7 seats]","Table 7 [6 seats]");
	public Float payment=0f;
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


 @FXML
    private VBox vBoxMain;

    @FXML
    private SplitPane splitPane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private AnchorPane anchorPane2;

    @FXML
    private Label planLbl;

    @FXML
    private Font x6;

    @FXML
    private Label nSesats;

    @FXML
    private Button confirmBtn;

    @FXML
    private Tooltip confirmToolTip;

    @FXML
    private Button deleteBtn;

    @FXML
    private Tooltip deleteToolTip;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button table5Btn;

    @FXML
    private Button table1Btn;

    @FXML
    private Button table2Btn;

    @FXML
    private Button table6Btn;

    @FXML
    private Button table7Btn;
     @FXML
    private ImageView cigerette;

    @FXML
    private ImageView cigerette1;

    @FXML
    private ImageView cigerette11;

    @FXML
    private ImageView cigerette111;


    @FXML
    private ImageView premiumStar2;

    @FXML
    private Button table3Btn;

    @FXML
    private Button table4Btn;

    @FXML
    private ImageView premiumStar21;

    @FXML
    private Separator separator;

    @FXML
    private ImageView image1;

    @FXML
    private Label appitizerLbl;

    @FXML
    private Label mainCourseLbl;

    @FXML
    private Label soupPrice;

    @FXML
    private Label totalPriceLbl;

    @FXML
    private Button saveBtn;

    @FXML
    private Label totalPrice;

    @FXML
    private Label LE;

    @FXML
    private Label welcomeLbl;

    @FXML
    private Font x1;

    @FXML
    private AnchorPane scrollMain;

    @FXML
    private ImageView steakImage;

    @FXML
    private ImageView grilledChickenImage;

    @FXML
    private ImageView mushroomSoupImage;

    @FXML
    private Button AddSteak;

    @FXML
    private Button AddChicken;

    @FXML
    private Button AddSoup;

    @FXML
    private Label steak;

    @FXML
    private Label steakPrice;

    @FXML
    private Label grilledChicken;

    @FXML
    private Label grilledChickenPrice;

    @FXML
    private Label mushroomSoup;

    @FXML
    private Label mainCourseLbl1;

    @FXML
    private ScrollPane scrollDessert;

    @FXML
    private AnchorPane anchorDessert;

    @FXML
    private Label applePie;

    @FXML
    private Label applePiePrice;

    @FXML
    private Label grilledChicken1;

    @FXML
    private Label moltenCakePrice;

    @FXML
    private ImageView applePieImage;

    @FXML
    private ImageView moltenCakeImage;

    @FXML
    private Button AddApplePie;

    @FXML
    private Button AddMoltenCake;

    @FXML
    private ScrollPane scrollApetizers;

    @FXML
    private AnchorPane anchorAppitizers;

    @FXML
    private ImageView greekSaladImage;

    @FXML
    private ImageView friesImage;

    @FXML
    private Button addGreekSalad;

    @FXML
    private Button AddFries;

    @FXML
    private Label greekSalad;

    @FXML
    private Label greekSaladPrice;

    @FXML
    private Label fries;

    @FXML
    private Label friesPrice;
    @FXML
    private Label usernameLbl;

    @FXML
    private ChoiceBox<String> seats;
    @FXML
    void confirmReservation(ActionEvent event) {

	 if(seats.getValue()=="Table 1 [5 seats]")
		{
		    Restaurant.mainRestaurant.setK(0);
	    	Restaurant.mainRestaurant.xmlModifier(Restaurant.mainRestaurant.getK(),true);
			table1Btn.setStyle("-fx-background-color: #494545");
			confirmBtn.setDisable(true);
		}
	  else	if(seats.getValue()=="Table 2 [12 seats]")
		{
			Restaurant.mainRestaurant.setK(1);
    	    Restaurant.mainRestaurant.xmlModifier(Restaurant.mainRestaurant.getK(),true);
		    table2Btn.setStyle("-fx-background-color: #494545");
			confirmBtn.setDisable(true);

		}
	  else if(seats.getValue()=="Table 3 [12 seats]")
		{
			    Restaurant.mainRestaurant.setK(2);
		    	Restaurant.mainRestaurant.xmlModifier(Restaurant.mainRestaurant.getK(),true);
				table3Btn.setStyle("-fx-background-color: #494545");
				confirmBtn.setDisable(true);

		}
	  else	if(seats.getValue()=="Table 4 [4 seats]")
		{
			 Restaurant.mainRestaurant.setK(3);
		    	Restaurant.mainRestaurant.xmlModifier(Restaurant.mainRestaurant.getK(),true);
		     table4Btn.setStyle("-fx-background-color: #494545");
			 confirmBtn.setDisable(true);


		}

	  else if(seats.getValue()=="Table 5 [4 seats]")
		{
			    Restaurant.mainRestaurant.setK(4);
		    	Restaurant.mainRestaurant.xmlModifier(Restaurant.mainRestaurant.getK(),true);
				table5Btn.setStyle("-fx-background-color: #494545");
				confirmBtn.setDisable(true);
		}
	  else if(seats.getValue()=="Table 6 [7 seats]")
		{
			    Restaurant.mainRestaurant.setK(5);
		    	Restaurant.mainRestaurant.xmlModifier(Restaurant.mainRestaurant.getK(),true);
				table6Btn.setStyle("-fx-background-color: #494545");
				confirmBtn.setDisable(true);

		}

	  else if(seats.getValue()=="Table 7 [6 seats]")
		{
			    Restaurant.mainRestaurant.setK(6);
		    	Restaurant.mainRestaurant.xmlModifier(Restaurant.mainRestaurant.getK(),true);
				table1Btn.setStyle("-fx-background-color: #494545");
				confirmBtn.setDisable(true);
		}
	  else {
		  confirmAlert.setContentText("No tables checked.");
			confirmAlert.show();
	}


    }
    
    @FXML
    public void setClientUser(SystemUser clientUser) {
    	 
    	
     	welcomeLbl.setText("Welcome, " + clientUser.name);

    }

    @FXML
    void deleteReservation(ActionEvent event) {

		deleteAlert.setContentText("Reservations cancelled");
		deleteAlert.show();

    	for(int i=0;i<7;i++)
    	{
    		Restaurant.mainRestaurant.setK(i);
    		Restaurant.mainRestaurant.xmlModifier(Restaurant.mainRestaurant.getK(), false);
    	}
		table1Btn.setStyle("-fx-background-color: #000000");
		table2Btn.setStyle("-fx-background-color: #000000");
		table3Btn.setStyle("-fx-background-color: #000000");
		table4Btn.setStyle("-fx-background-color: #000000");
		table5Btn.setStyle("-fx-background-color: #000000");
		table6Btn.setStyle("-fx-background-color: #000000");
		table7Btn.setStyle("-fx-background-color: #000000");
		confirmBtn.setDisable(false);

    }

    @FXML
    void orderCake(ActionEvent event) {
    	setnCake(+1);
		setTotalPrice(+dishOrder.setPriceAfterTax(4, getnCake(), dessertTax));
		payment+=getTotalPrice();
		totalPriceLbl.setText(""+payment);


    }

    @FXML
    void orderChicken(ActionEvent event) {
    	setnChicken(+1);
		setTotalPrice(+dishOrder.setPriceAfterTax(0, getnChicken(), mainTax));
		totalPriceLbl.setText(""+getTotalPrice());
		payment+=getTotalPrice();
		totalPriceLbl.setText(""+payment);
    }

    @FXML
    void orderFries(ActionEvent event) {
    	setnFries(+1);
		setTotalPrice(+dishOrder.setPriceAfterTax(2, getnFries(), appetizerTax));
		payment+=getTotalPrice();
		totalPriceLbl.setText(""+payment);
    }

    @FXML
    void orderPie(ActionEvent event) {
    	setnPie(+1);
		setTotalPrice(+dishOrder.setPriceAfterTax(3, getnPie(), dessertTax));
		payment+=getTotalPrice();
		totalPriceLbl.setText(""+payment);

    }

    @FXML
    void orderSalad(ActionEvent event) {
    	setnSalad(+1);
		setTotalPrice(dishOrder.setPriceAfterTax(1, getnSalad(), appetizerTax));
		payment+=getTotalPrice();
		totalPriceLbl.setText(""+payment);

    }

    @FXML
    void orderSoup(ActionEvent event) {
    	setnSoup(+1);
		setTotalPrice(+dishOrder.setPriceAfterTax(5, getnSoup(), mainTax));
		payment+=getTotalPrice();
		totalPriceLbl.setText(""+payment);

    }

    @FXML
    void orderSteak(ActionEvent event) {
    	setnSteak(+1);
		setTotalPrice(+dishOrder.setPriceAfterTax(6, getnSteak(), mainTax));
		payment+=getTotalPrice();
		totalPriceLbl.setText(""+payment);


    }


	Alert confirmAlert = new Alert(AlertType.ERROR);
	Alert deleteAlert = new Alert(AlertType.CONFIRMATION);
   private  Integer tableNumber=0;
   private Integer seatsCount=0;
   private Boolean isSmoking=false;
   private Boolean isReserved=false;

    public Integer getTableNumber() {
	return tableNumber;
}


public void setTableNumber(Integer tableNumber) {
	this.tableNumber = tableNumber;
}


public Integer getSeatsCount() {
	return seatsCount;
}


public void setSeatsCount(Integer seatsCount) {
	this.seatsCount = seatsCount;
}


public Boolean getIsSmoking() {
	return isSmoking;
}


public void setIsSmoking(Boolean isSmoking) {
	this.isSmoking = isSmoking;
}


public Boolean getIsReserved() {
	return isReserved;
}


public void setIsReserved(Boolean isReserved) {
	this.isReserved = isReserved;
}


	final Table table=new Table(tableNumber, seatsCount, isSmoking, isReserved);
	final DishOrder dishOrder = new DishOrder();
	public	ArrayList<Integer> reservedTables= new ArrayList<Integer>();
	private Integer nSalad,nFries,nSteak,nChicken,nSoup,nPie,nCake=0;
	public Integer getnSalad() {
		return nSalad;
	}


	public void setnSalad(Integer nSalad) {
		this.nSalad = nSalad;
	}


	public Integer getnFries() {
		return nFries;
	}


	public void setnFries(Integer nFries) {
		this.nFries = nFries;
	}


	public Integer getnSteak() {
		return nSteak;
	}


	public void setnSteak(Integer nSteak) {
		this.nSteak = nSteak;
	}


	public Integer getnChicken() {
		return nChicken;
	}


	public void setnChicken(Integer nChicken) {
		this.nChicken = nChicken;
	}


	public Integer getnSoup() {
		return nSoup;
	}


	public void setnSoup(Integer nSoup) {
		this.nSoup = nSoup;
	}


	public Integer getnPie() {
		return nPie;
	}


	public void setnPie(Integer nPie) {
		this.nPie = nPie;
	}


	public Integer getnCake() {
		return nCake;
	}


	public void setnCake(Integer nCake) {
		this.nCake = nCake;
	}

	final Float appetizerTax=0.10f;
	final Float mainTax=0.15f;
	final Float dessertTax=0.20f;
	private Float totalPayment;
	public Float getTotalPrice() {
		return totalPayment;
	}


	public void setTotalPrice(Float totalPayment) {
		this.totalPayment = totalPayment;
	}



	@Override

	public void initialize(URL location, ResourceBundle resources) {
    	seats.setItems(list);

			}


	}
