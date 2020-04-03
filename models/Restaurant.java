package models;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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

	private int k;

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
	
	public void xmlModifier(String doOperation,int k,boolean isReseved,Float payment,int clientIndex)
	{
		try {
			String filepath = "Restaurant.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);
			if(doOperation=="table")
			{
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
			}
			else if (doOperation=="payment") {
				// Get the root element
				Node users = doc.getElementsByTagName("user").item(clientIndex);
				// loop the staff child node
				NodeList list = users.getChildNodes();

				for (int i = 0; i < list.getLength(); i++) {

		                Node node = list.item(i);
				   // get the is reserved element, and update the value
				   if ("payment".equals(node.getNodeName())) {
					node.setTextContent(""+payment);
				   }
				   else
					   node.setTextContent("0");
				}
			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);
			System.out.println("Done");
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
			// TODO: handle exception


	}
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
					Boolean isReservedTable = Boolean.parseBoolean(tableElement.getElementsByTagName("isReserved").item(0).getTextContent());
					tables.add(new Table(tableNumber, seatsCount, isSmokingTable,isReservedTable));

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
