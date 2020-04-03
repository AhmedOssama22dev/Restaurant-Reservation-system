package models;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javafx.stage.Stage;

public class XMLModifier extends  javafx.application.Application{
	


		public XMLModifier() {
		super();
		// TODO Auto-generated constructor stub
	}

		
		public void change(int k) {
			// TODO Auto-generated method stub
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
				   if ("isReserved".equals(node.getNodeName())) {
					node.setTextContent("true");
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


		@Override
		public void start(Stage arg0) throws Exception {
			// TODO Auto-generated method stub
			
		}
		
}
