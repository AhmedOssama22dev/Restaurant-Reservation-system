package models;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Restaurant {

	public static Restaurant mainRestaurant = new Restaurant();

	public ArrayList<SystemUser> systemUsers = new ArrayList<SystemUser>();
	public ArrayList<Table> tables = new ArrayList<Table>();
	public ArrayList<Dish> dishes = new ArrayList<Dish>();

	public SystemUser currentLoggedInUser;
	private int k;

	private Restaurant() {
		fetchUpdatedData();
	}
	
	public int getK() {
	return k;
}


	public void setK(int k) {
	this.k = k;

}
	/**
	 * @return the returned user will be null if the authentication process fails
	 *
	 */
	public SystemUser authenticate(String username, String password) {

		SystemUser returnedUser = null;

		for (SystemUser user : systemUsers) {
			if (user.username.equals(username) && user.password.equals(password)) {
				returnedUser = user;
				break;
			}
		}

		return returnedUser;
	}
	
	public static void showAlert(AlertType type, String title, String headerText, String contentText) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		alert.showAndWait(); 
	}
	
	public void xmlModifier(int k,boolean isReseved)
	{
		try {
			
			String filepath = "Restaurant.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);
			
			// Get the root element
			Node tables = doc.getElementsByTagName("table").item(k);
			// loop the staff child node
			NodeList list = tables.getChildNodes();

			for (int i = 0; i < list.getLength(); i++) {

	                Node node = list.item(i);
			   // get the is reserved element, and update the value
			   if ("isReserved".equals(node.getNodeName())&&isReseved) {
				node.setTextContent("true");
			   }
			   else if("isReserved".equals(node.getNodeName())&&!isReseved)
			   {
				   node.setTextContent("false");
			   }
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);
			System.out.println("Done");
		} catch (ParserConfigurationException pce) {
				pce.printStackTrace();
	    } catch (TransformerException tfe) {
				tfe.printStackTrace();
		} catch (IOException ioe) {
				ioe.printStackTrace();
	    } catch (SAXException sae) {
				sae.printStackTrace();
		 }
	}
	
	
	public void saveMeal(String clientName, String meal) {
		try {
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse("Restaurant.xml");
			
			Node tables = doc.getElementsByTagName("table").item(k);
			NodeList list = tables.getChildNodes();

			for (int i = 0; i < list.getLength(); i++) {

	           Node node = list.item(i);

	           if ("orderedMeals".equals(node.getNodeName())) {

	        	   Element addedMeal = doc.createElement("meal");
	               node.appendChild(addedMeal);
	               
	               Element addedClientName = doc.createElement("client");
	               addedClientName.appendChild(doc.createTextNode(clientName));
	               addedMeal.appendChild(addedClientName);
	    
	               Element mealName = doc.createElement("name");
	               mealName.appendChild(doc.createTextNode(meal));
	               addedMeal.appendChild(mealName);
	           }
			   
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("Restaurant.xml"));
			transformer.transform(source, result);
		}
			catch (ParserConfigurationException pce) {
				pce.printStackTrace();
			   } catch (TransformerException tfe) {
				tfe.printStackTrace();
			   } catch (IOException ioe) {
				ioe.printStackTrace();
			   } catch (SAXException sae) {
				sae.printStackTrace();
			   }
	}
	
	public ObservableList<Reservation> fetchReservations() {

		fetchUpdatedData();

		ObservableList<Reservation> reservations = FXCollections.observableArrayList();
		
		for (Table table : tables) {
			if (table.isReserved == true) {
				Reservation reservation = new Reservation("", table.tableNumber, table.seatsCount, table.isSmoking);
				if (table.getOrderedMeals().get(0) != null) {
					System.out.print("ZEBY");
					System.out.print(table);
					reservation.setClientName(table.getOrderedMeals().get(0).clientName);
				}
				
				System.out.print(reservation);
				reservations.add(reservation);
			}
		}
		
		return reservations;
	}
	
	public ObservableList<Check> fetchCheckouts() {

		fetchUpdatedData();

		ObservableList<Check> checkouts = FXCollections.observableArrayList();
		
		for (Table table : tables) {
			if (table.isReserved == true) {
				Integer totalAmount = 0;
				
				for (OrderedMeal meal : table.getOrderedMeals()) {
					totalAmount += meal.getPrice();
				}
				
				Check check = new Check(table.tableNumber, totalAmount);
				checkouts.add(check);
			}
		}
		
		return checkouts;
	}
	
	public ObservableList<OrderedMeal> fetchOrderedMeals() {

		fetchUpdatedData();

		ObservableList<OrderedMeal> orderedMeals = FXCollections.observableArrayList();
		
		for (Table table : tables) {
			if (table.isReserved == true) {
				for (OrderedMeal meal : table.getOrderedMeals()) {
					orderedMeals.add(meal);
				}
			}
		}
		
		return orderedMeals;
	}
	
	public ObservableList<SystemUser> fetchSystemUsers() {

		fetchUpdatedData();

		ObservableList<SystemUser> systemUsersList = FXCollections.observableArrayList();
		
		for (SystemUser systemUser : systemUsers) {
			systemUsersList.add(systemUser);
		}
		
		return systemUsersList;
	}
	
	private void fetchUpdatedData() {
		
		tables.clear();
		dishes.clear();
		systemUsers.clear();
		
		try {

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(new File("Restaurant.xml"));

			NodeList usersList = document.getElementsByTagName("user");
			NodeList tablesList = document.getElementsByTagName("table");
			NodeList dishList = document.getElementsByTagName("dish");


			for (int index = 0; index < usersList.getLength(); index = index + 1) {

				Node userNode = usersList.item(index);

				if (userNode.getNodeType() == Node.ELEMENT_NODE) {
					Element userElement = (Element)userNode;

					String systemUserName = userElement.getElementsByTagName("name").item(0).getTextContent();
					String systemUserRole = userElement.getElementsByTagName("role").item(0).getTextContent();
					String systemUserUsername = userElement.getElementsByTagName("username").item(0).getTextContent();
					String systemUserPassword = userElement.getElementsByTagName("password").item(0).getTextContent();

					systemUsers.add(new SystemUser(systemUserName, systemUserRole, systemUserUsername, systemUserPassword));
				}
			}


			for (int index = 0; index < dishList.getLength(); index = index + 1) {

				Node dishNode = dishList.item(index);

				if (dishNode.getNodeType() == Node.ELEMENT_NODE) {
					Element dishElement = (Element)dishNode;

					String dishName = dishElement.getElementsByTagName("name").item(0).getTextContent();
					Integer dishPrice = Integer.parseInt(dishElement.getElementsByTagName("price").item(0).getTextContent());
					String dishCategory = dishElement.getElementsByTagName("type").item(0).getTextContent();

					dishes.add(new Dish(dishName, dishPrice, dishCategory));
				}
			}
			
			for (int index = 0; index < tablesList.getLength(); index = index + 1) {

				Node tableNode = tablesList.item(index);

				if (tableNode.getNodeType() == Node.ELEMENT_NODE) {
					Element tableElement = (Element)tableNode;

					Integer tableNumber = Integer.parseInt(tableElement.getElementsByTagName("number").item(0).getTextContent());
					Integer seatsCount = Integer.parseInt(tableElement.getElementsByTagName("number_of_seats").item(0).getTextContent());
					Boolean isSmokingTable = Boolean.parseBoolean(tableElement.getElementsByTagName("smoking").item(0).getTextContent());
					Boolean isReservedTable = Boolean.parseBoolean(tableElement.getElementsByTagName("isReserved").item(0).getTextContent());
					ArrayList<OrderedMeal> orderedMeals = new ArrayList<OrderedMeal>();
					
					NodeList orderedMealsList = tableElement.getElementsByTagName("meal");

					for (int newIndex = 0; newIndex < orderedMealsList.getLength(); newIndex = newIndex + 1) {
						
						Node orderedMealNode = orderedMealsList.item(newIndex);
					
						if (orderedMealNode.getNodeType() == Node.ELEMENT_NODE) {
							Element orderedMealElement = (Element)orderedMealNode;

							String orderedMealClientName = orderedMealElement.getElementsByTagName("client").item(0).getTextContent();
							String orderedMealName = orderedMealElement.getElementsByTagName("name").item(0).getTextContent();
														
							Dish referencedDish = new Dish();
							
							for (Dish d : dishes) {
								if (orderedMealName.equals(d.name)) {
									referencedDish = d;
								}
							}
							
							orderedMeals.add(new OrderedMeal(orderedMealClientName, referencedDish.getCategory(), referencedDish.name, tableNumber, referencedDish.price));
						}
						
						
					}
					
					tables.add(new Table(tableNumber, seatsCount, isSmokingTable, isReservedTable, orderedMeals));

				}
			}
		
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
