package models;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;

public class Restaurant {

	public static Restaurant mainRestaurant = new Restaurant();
	
	public ArrayList<SystemUser> systemUsers = new ArrayList<SystemUser>();
	public ArrayList<Table> tables = new ArrayList<Table>();
	public ArrayList<Dish> dishes = new ArrayList<Dish>();
	
	private Restaurant() {
		
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
			
			
			for (int index = 0; index < tablesList.getLength(); index = index + 1) {
			
				Node tableNode = tablesList.item(index);
				
				if (tableNode.getNodeType() == Node.ELEMENT_NODE) {  
					Element tableElement = (Element)tableNode;  
					
					Integer tableNumber = Integer.parseInt(tableElement.getElementsByTagName("number").item(0).getTextContent());
					Integer seatsCount = Integer.parseInt(tableElement.getElementsByTagName("number_of_seats").item(0).getTextContent());
					Boolean isSmokingTable = Boolean.parseBoolean(tableElement.getElementsByTagName("smoking").item(0).getTextContent());
					
					tables.add(new Table(tableNumber, seatsCount, isSmokingTable)); 
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
		
		}  catch (Exception e) {  
			e.printStackTrace();  
		}   
	}
}
