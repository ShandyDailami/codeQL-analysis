import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_29269_XMLParser_A08 {

    public static void main(String[] args) {
        // Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create a DocumentBuilder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file into a Document object
            Document document = builder.parse(new File("path_to_your_xml_file.xml"));

            // Get all the nodes of the document
            NodeList nodes = document.getElementsByTagName("node");

            // Do something with the nodes
            for (int i = 0; i < nodes.getLength(); i++) {
                // Here you can add security-sensitive operations
                // For instance, you can print the content of each node
                System.out.println("Node " + (i + 1) + " content: " + nodes.item(i).getTextContent());
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}