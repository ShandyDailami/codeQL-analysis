import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_14528_XMLParser_A08 {
    public static void main(String[] args) {
        // Create a factory for building a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Use the factory to create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(new File("example.xml"));

            // Get all the 'item' nodes
            NodeList nodeList = document.getElementsByTagName("item");

            // Iterate over the 'item' nodes
            for (int i = 0; i < nodeList.getLength(); i++) {
                // Get the current node
                org.w3c.dom.Node node = nodeList.item(i);

                // Extract and print the 'title' attribute of the current node
                System.out.println("Title: " + node.getAttributes().getNamedItem("title").getTextContent());
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}