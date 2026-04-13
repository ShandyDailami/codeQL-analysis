import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_16555_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml");

            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file into a Document object
            Document doc = dBuilder.parse(xmlFile);

            // Get the root element of the Document
            doc.getDocumentElement().normalize();

            // Get all the children of the root element
            NodeList nodeList = doc.getElementsByTagName("tagName"); // replace "tagName" with the actual tag name you want to parse

            // Iterate over all the children
            for (int i = 0; i < nodeList.getLength(); i++) {
                // Get the current child element
                Node node = nodeList.item(i);

                // You can now parse each child element as needed
                // ...
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}