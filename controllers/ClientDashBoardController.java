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
import models.DishOrder;
import models.Restaurant;
import models.Table;


public class ClientDashBoardController extends Stage implements Initializable{

	ObservableList<String> list = FXCollections.observableArrayList("4(Table4)","4(Table5)","5","6","7","12","12");
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
    private AnchorPane anchorPane1;

    @FXML
    private Label welcomeLbl;

    @FXML
    private Font x1;

    @FXML
    private Button menuBtn;

    @FXML
    private Tooltip menuToolTip;

    @FXML
    private Label reservedTblLbl;

    @FXML
    private Label someReservedLbl;

    @FXML
    private Label selectedFoodLbl;

    @FXML
    private Label someFoodLbl;

    @FXML
    private Button saveBtn;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private AnchorPane anchorPane2;

    @FXML
    private Label planLbl;

    @FXML
    private Color x5;

    @FXML
    private Font x6;

    @FXML
    private Button table3Btn;

    @FXML
    private Button table4Btn;

    @FXML
    private VBox vBox2;



    @FXML
    private VBox vBox3;


    @FXML
    private Label nSesats;

    @FXML
    private Label chooseTablesLbl;

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
    private ImageView premiumStar;

    @FXML
    private ImageView premiumStar2;

    @FXML
    private Separator separator;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView menuBackgrd;

    @FXML
    private ImageView greekSaladImage;

    @FXML
    private ImageView friesImage;

    @FXML
    private Label appitizerLbl;

    @FXML
    private Label mainCourseLbl;

    @FXML
    private Label dessertLbl;

    @FXML
    private ImageView steakImage;

    @FXML
    private ImageView grilledChickenImage;

    @FXML
    private ImageView mushroomSoupImage;

    @FXML
    private ImageView applePieImage;

    @FXML
    private ImageView moltenCakeImage;

    @FXML
    private Button addGreekSalad;

    @FXML
    private Button AddChicken;

    @FXML
    private Button AddSteak;

    @FXML
    private Button AddSoup;

    @FXML
    private Button AddApplePie;

    @FXML
    private Button AddMoltenCake;

    @FXML
    private Label greekSaladPrice;

    @FXML
    private Label FriesPrice;

    @FXML
    private Label steakPrice;

    @FXML
    private Label grilledChickenPrice;

    @FXML
    private Label piePrice;

    @FXML
    private Label moltenPrice;

    @FXML
    private Label soupPrice;

    @FXML
    private Button AddFries;
    @FXML
    private Label totalPriceLbl;
    @FXML
    private Label res1;

    @FXML
    private Label res2;

    @FXML
    private Label res3;

    @FXML
    private Label res4;

    @FXML
    private Label res5;

    @FXML
    private ChoiceBox<String> seats;
    @FXML
    private Button paymentBtn;

    @FXML
    void confirmReservation(ActionEvent event) {
    	
	 if(seats.getValue()=="5")
		{
		    Restaurant.mainRestaurant.setK(0);
	    	Restaurant.mainRestaurant.xmlModifier("table",Restaurant.mainRestaurant.getK(),true,(float) 0,0);
			table1Btn.setStyle("-fx-background-color: #ae1313");
			res1.setText("Table1");
			confirmBtn.setDisable(true);
		}
	  else	if(seats.getValue()=="12")
		{
			Restaurant.mainRestaurant.setK(1);
    	    Restaurant.mainRestaurant.xmlModifier("table",Restaurant.mainRestaurant.getK(),true,0f,0);
		    table2Btn.setStyle("-fx-background-color: #ae1313");
		    res1.setText("Table 2");
			confirmBtn.setDisable(true);

		}
	  else if(seats.getValue()=="12")
		{
			    Restaurant.mainRestaurant.setK(2);
		    	Restaurant.mainRestaurant.xmlModifier("table",Restaurant.mainRestaurant.getK(),true,0f,0);
				table3Btn.setStyle("-fx-background-color: #ae1313");
				res1.setText("Table 3");
				confirmBtn.setDisable(true);

		}
	  else	if(seats.getValue()=="4(Table4)")
		{
			 Restaurant.mainRestaurant.setK(3);
    	     Restaurant.mainRestaurant.xmlModifier("table",Restaurant.mainRestaurant.getK(),true,0f,0);
		     table4Btn.setStyle("-fx-background-color: #ae1313");
		     res1.setText("Table 4");
			 confirmBtn.setDisable(true);


		}

	  else if(seats.getValue()=="5(Table5)")
		{
			    Restaurant.mainRestaurant.setK(4);
		    	Restaurant.mainRestaurant.xmlModifier("table",Restaurant.mainRestaurant.getK(),true,0f,0);
				table5Btn.setStyle("-fx-background-color: #ae1313");
				res1.setText("Table 5");
				confirmBtn.setDisable(true);
		}
	  else if(seats.getValue()=="6")
		{
			    Restaurant.mainRestaurant.setK(5);
		    	Restaurant.mainRestaurant.xmlModifier("table",Restaurant.mainRestaurant.getK(),true,0f,0);
				table6Btn.setStyle("-fx-background-color: #ae1313");
				res1.setText("Table 6");
				confirmBtn.setDisable(true);

		}

	  else if(seats.getValue()=="7")
		{
			    Restaurant.mainRestaurant.setK(6);
		    	Restaurant.mainRestaurant.xmlModifier("table",Restaurant.mainRestaurant.getK(),true,0f,0);
				table1Btn.setStyle("-fx-background-color: #ae1313");
				res1.setText("Table 7");
				confirmBtn.setDisable(true);
		}
	  else {
		  confirmAlert.setContentText("No tables checked.");
			confirmAlert.show();
	}


    }

    @FXML
    void deleteReservation(ActionEvent event) {

		deleteAlert.setContentText("Reservations cancelled");
		deleteAlert.show();

    	for(int i=0;i<7;i++)
    	{
    		Restaurant.mainRestaurant.setK(i);
    		Restaurant.mainRestaurant.xmlModifier("table",Restaurant.mainRestaurant.getK(), false,0f,0);
    	}
		table1Btn.setStyle("-fx-background-color: #ffffff");
		table2Btn.setStyle("-fx-background-color: #ffffff");
		table3Btn.setStyle("-fx-background-color: #ffffff");
		table4Btn.setStyle("-fx-background-color: #ffffff");
		table5Btn.setStyle("-fx-background-color: #ffffff");
		table6Btn.setStyle("-fx-background-color: #ffffff");
		table7Btn.setStyle("-fx-background-color: #ffffff");
		res1.setText("");
		confirmBtn.setDisable(false);

    }

    @FXML
    void orderCake(ActionEvent event) {
    	setnCake(+1);
		setTotalPrice(+dishOrder.setPriceAfterTax(4, getnCake(), dessertTax));
		payment+=getTotalPrice();


    }

    @FXML
    void orderChicken(ActionEvent event) {
    	setnChicken(+1);
		setTotalPrice(+dishOrder.setPriceAfterTax(0, getnChicken(), mainTax));
		totalPriceLbl.setText(""+getTotalPrice());
		payment+=getTotalPrice();
    }

    @FXML
    void orderFries(ActionEvent event) {
    	setnFries(+1);
		setTotalPrice(+dishOrder.setPriceAfterTax(2, getnFries(), appetizerTax));
		payment+=getTotalPrice();
    }

    @FXML
    void orderPie(ActionEvent event) {
    	setnPie(+1);
		setTotalPrice(+dishOrder.setPriceAfterTax(3, getnPie(), dessertTax));
		payment+=getTotalPrice();

    }

    @FXML
    void orderSalad(ActionEvent event) {
    	setnSalad(+1);
		setTotalPrice(dishOrder.setPriceAfterTax(1, getnSalad(), appetizerTax));
		payment+=getTotalPrice();

    }

    @FXML
    void orderSoup(ActionEvent event) {
    	setnSoup(+1);
		setTotalPrice(+dishOrder.setPriceAfterTax(5, getnSoup(), mainTax));
		payment+=getTotalPrice();

    }

    @FXML
    void orderSteak(ActionEvent event) {
    	setnSteak(+1);
		setTotalPrice(+dishOrder.setPriceAfterTax(6, getnSteak(), mainTax));
		payment+=getTotalPrice();


    }
    @FXML
    void payment(ActionEvent event) {
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
	private Float totalPrice;
	public Float getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}



	@Override

	public void initialize(URL location, ResourceBundle resources) {
    	seats.setItems(list);

			}


	}
