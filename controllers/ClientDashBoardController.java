package controllers;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.lang.model.element.Element;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.w3c.dom.NodeList;

import java.net.URL;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
import javafx.stage.Stage;
import models.DishOrder;
import models.Restaurant;
import models.Table;


public class ClientDashBoardController implements Initializable{
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
    private CheckBox table1Lbl;

    @FXML
    private CheckBox table2Lbl;

    @FXML
    private CheckBox table3Lbl;

    @FXML
    private CheckBox table4Lbl;

    @FXML
    private CheckBox table5Lbl;

    @FXML
    private CheckBox table6Lbl;

    @FXML
    private CheckBox table7Lbl;

    @FXML
    private VBox vBox3;

    @FXML
    private Label tbl1Seat;

    @FXML
    private Label table2Seat;

    @FXML
    private Label table3Seat;

    @FXML
    private Label table5Seat;

    @FXML
    private Label table6Seat;

    @FXML
    private Label table7Seat;

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


	@FXML
    void initialize() { assert vBoxMain != null : "fx:id=\"vBoxMain\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert splitPane != null : "fx:id=\"splitPane\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert anchorPane1 != null : "fx:id=\"anchorPane1\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert welcomeLbl != null : "fx:id=\"welcomeLbl\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert x1 != null : "fx:id=\"x1\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert menuBtn != null : "fx:id=\"menuBtn\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert menuToolTip != null : "fx:id=\"menuToolTip\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert reservedTblLbl != null : "fx:id=\"reservedTblLbl\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert someReservedLbl != null : "fx:id=\"someReservedLbl\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert selectedFoodLbl != null : "fx:id=\"selectedFoodLbl\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert someFoodLbl != null : "fx:id=\"someFoodLbl\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert saveBtn != null : "fx:id=\"saveBtn\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert scrollPane != null : "fx:id=\"scrollPane\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert anchorPane2 != null : "fx:id=\"anchorPane2\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert planLbl != null : "fx:id=\"planLbl\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert x5 != null : "fx:id=\"x5\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert x6 != null : "fx:id=\"x6\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert table3Btn != null : "fx:id=\"table3Btn\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert table4Btn != null : "fx:id=\"table4Btn\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert vBox2 != null : "fx:id=\"vBox2\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert table1Lbl != null : "fx:id=\"table1Lbl\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert table2Lbl != null : "fx:id=\"table2Lbl\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert table3Lbl != null : "fx:id=\"table3Lbl\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert table4Lbl != null : "fx:id=\"table4Lbl\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert table5Lbl != null : "fx:id=\"table5Lbl\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert table6Lbl != null : "fx:id=\"table6Lbl\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert table7Lbl != null : "fx:id=\"table7Lbl\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert vBox3 != null : "fx:id=\"vBox3\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert tbl1Seat != null : "fx:id=\"tbl1Seat\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert table2Seat != null : "fx:id=\"table2Seat\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert table3Seat != null : "fx:id=\"table3Seat\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert table5Seat != null : "fx:id=\"table5Seat\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert table6Seat != null : "fx:id=\"table6Seat\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert table7Seat != null : "fx:id=\"table7Seat\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert nSesats != null : "fx:id=\"nSesats\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert chooseTablesLbl != null : "fx:id=\"chooseTablesLbl\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert confirmBtn != null : "fx:id=\"confirmBtn\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert confirmToolTip != null : "fx:id=\"confirmToolTip\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert deleteBtn != null : "fx:id=\"deleteBtn\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert deleteToolTip != null : "fx:id=\"deleteToolTip\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert table5Btn != null : "fx:id=\"table5Btn\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert table1Btn != null : "fx:id=\"table1Btn\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert table2Btn != null : "fx:id=\"table2Btn\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert table6Btn != null : "fx:id=\"table6Btn\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert table7Btn != null : "fx:id=\"table7Btn\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert premiumStar != null : "fx:id=\"premiumStar\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert premiumStar2 != null : "fx:id=\"premiumStar2\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert separator != null : "fx:id=\"separator\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert image1 != null : "fx:id=\"image1\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert menuBackgrd != null : "fx:id=\"menuBackgrd\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert greekSaladImage != null : "fx:id=\"greekSaladImage\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert friesImage != null : "fx:id=\"friesImage\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert appitizerLbl != null : "fx:id=\"appitizerLbl\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert mainCourseLbl != null : "fx:id=\"mainCourseLbl\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert dessertLbl != null : "fx:id=\"dessertLbl\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert steakImage != null : "fx:id=\"steakImage\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert grilledChickenImage != null : "fx:id=\"grilledChickenImage\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert mushroomSoupImage != null : "fx:id=\"mushroomSoupImage\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert applePieImage != null : "fx:id=\"applePieImage\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert moltenCakeImage != null : "fx:id=\"moltenCakeImage\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert addGreekSalad != null : "fx:id=\"addGreekSalad\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert AddChicken != null : "fx:id=\"AddChicken\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert AddSteak != null : "fx:id=\"AddSteak\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert AddSoup != null : "fx:id=\"AddSoup\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert AddApplePie != null : "fx:id=\"AddApplePie\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert AddMoltenCake != null : "fx:id=\"AddMoltenCake\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert greekSaladPrice != null : "fx:id=\"greekSaladPrice\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert FriesPrice != null : "fx:id=\"FriesPrice\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert steakPrice != null : "fx:id=\"steakPrice\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert grilledChickenPrice != null : "fx:id=\"grilledChickenPrice\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert piePrice != null : "fx:id=\"piePrice\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert moltenPrice != null : "fx:id=\"moltenPrice\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert soupPrice != null : "fx:id=\"soupPrice\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
        assert AddFries != null : "fx:id=\"AddFries\" was not injected: check your FXML file 'ClientDashBoardView.fxml'.";
    }

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



	public void setupEvents() {

		final Table table=new Table(tableNumber, seatsCount, isSmoking, isReserved);
		final DishOrder dishOrder = new DishOrder();
		confirmBtn.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {

				if(table1Lbl.selectedProperty() != null)
				{
					setTableNumber(1);setSeatsCount(5);;setIsSmoking(false);setIsReserved(true);
					Restaurant.mainRestaurant.tables.set(0, table);
					reservedTables.add(0, 1);
					table1Btn.setStyle("-fx-background-color: #ae1313");
					System.out.println(Restaurant.mainRestaurant.tables.toString());
				}else {	reservedTables.add(0, 0);

				}
				if(table2Lbl.selectedProperty() != null)
				{
					setTableNumber(2);setSeatsCount(12);;setIsSmoking(false);setIsReserved(true);
					Restaurant.mainRestaurant.tables.set(1, table);
					reservedTables.add(1, 1);
					table2Btn.setStyle("-fx-background-color: #ae1313");

					System.out.println(Restaurant.mainRestaurant.tables.toString());
				}else reservedTables.add(1, 0);
				if(table3Lbl.selectedProperty() != null)
				{
					setTableNumber(3);setSeatsCount(12);;setIsSmoking(true);setIsReserved(true);
					Restaurant.mainRestaurant.tables.set(2, table);
					reservedTables.add(2, 1);
					table3Btn.setStyle("-fx-background-color: #ae1313");

					System.out.println(Restaurant.mainRestaurant.tables.toString());
				}else 	reservedTables.add(1, 0);
				if(table4Lbl.selectedProperty() != null)
				{
					setTableNumber(4);setSeatsCount(4);;setIsSmoking(false);setIsReserved(true);
					Restaurant.mainRestaurant.tables.set(3, table);
					reservedTables.add(3, 1);
					table4Btn.setStyle("-fx-background-color: #ae1313");

					System.out.println(Restaurant.mainRestaurant.tables.toString());
				}else reservedTables.add(3, 0);
				if(table5Lbl.selectedProperty() != null)
				{
					setTableNumber(5);setSeatsCount(4);;setIsSmoking(true);setIsReserved(true);
					Restaurant.mainRestaurant.tables.set(4, table);
					reservedTables.add(4, 1);
					table5Btn.setStyle("-fx-background-color: #ae1313");
					System.out.println(Restaurant.mainRestaurant.tables.toString());
				}else 	reservedTables.add(4, 0);
				if(table6Lbl.selectedProperty() != null)
				{
					setTableNumber(6);setSeatsCount(7);;setIsSmoking(true);setIsReserved(true);
					Restaurant.mainRestaurant.tables.set(5, table);
					reservedTables.add(5, 1);
					table6Btn.setStyle("-fx-background-color: #ae1313");

					System.out.println(Restaurant.mainRestaurant.tables.toString());
				}else 	reservedTables.add(5, 0);

				if(table7Lbl.selectedProperty() != null)
				{
					setTableNumber(7);setSeatsCount(6);;setIsSmoking(true);setIsReserved(true);
					Restaurant.mainRestaurant.tables.set(6, table);
					reservedTables.add(6, 1);
					table7Btn.setStyle("-fx-background-color: #ae1313");
					System.out.println(Restaurant.mainRestaurant.tables.toString());
				}else 	reservedTables.add(6, 0);

				if(table1Lbl.selectedProperty()==null&&table2Lbl.selectedProperty()==null&&table2Lbl.selectedProperty()==null&&table3Lbl.selectedProperty()==null&&table4Lbl.selectedProperty()==null&&table5Lbl.selectedProperty()==null&&table6Lbl.selectedProperty()==null&&table7Lbl.selectedProperty()==null)
				{
					confirmAlert.setContentText("No tables checked.");
					confirmAlert.show();
				}
				//check how to append text to a label
				/*for(int i=0;i<7;i++)
				{
					if(reservedTables.get(i)!=0)
					{
						someReservedLbl.setText("Table:"+reservedTables.get(i));
					}
				}*/

			}

		});
		deleteBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {


				for(int i=0;i<7;i++)
				{
					if(reservedTables.get(i)!=0)
					{
						setTableNumber(i);setSeatsCount(6);;setIsSmoking(true);setIsReserved(false);
						Restaurant.mainRestaurant.tables.set(6, table);
						reservedTables.set(i, 0);
					}
				}
				deleteAlert.setContentText("Reservations cancelled");
				deleteAlert.show();

			}
		});

		addGreekSalad.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				setnSalad(+1);
				setTotalPrice(dishOrder.setPriceAfterTax(1, getnSalad(), appetizerTax));
				totalPriceLbl.setText(""+getTotalPrice());

			}
		});
		AddFries.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				setnFries(+1);
				setTotalPrice(+dishOrder.setPriceAfterTax(2, getnFries(), appetizerTax));
				totalPriceLbl.setText(""+getTotalPrice());
			}
		});

		AddSteak.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				setnSteak(+1);
				setTotalPrice(+dishOrder.setPriceAfterTax(6, getnSteak(), mainTax));
				totalPriceLbl.setText(""+getTotalPrice());

			}
		});

		AddChicken.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				setnChicken(+1);
				setTotalPrice(+dishOrder.setPriceAfterTax(0, getnChicken(), mainTax));
				totalPriceLbl.setText(""+getTotalPrice());

			}
		});
		AddSoup.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				setnSoup(+1);
				setTotalPrice(+dishOrder.setPriceAfterTax(5, getnSoup(), mainTax));
				totalPriceLbl.setText(""+getTotalPrice());

			}
		});
		AddApplePie.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				setnPie(+1);
				setTotalPrice(+dishOrder.setPriceAfterTax(3, getnPie(), dessertTax));
				totalPriceLbl.setText(""+getTotalPrice());
			}
		});
		AddMoltenCake.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				setnCake(+1);
				setTotalPrice(+dishOrder.setPriceAfterTax(4, getnCake(), dessertTax));
				totalPriceLbl.setText(""+getTotalPrice());
			}
		});

	}
	@Override

	public void initialize(URL location, ResourceBundle resources) {
	}


	public ClientDashBoardController() {
		super();
		setupEvents();
	}


	}
