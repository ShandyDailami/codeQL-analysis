import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_40885_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a factory for the DOM parser
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input XML file into a Document object
            Document document = builder.parse(new File("input.xml"));

            // Get a list of the nodes in the document
            NodeList nodeList = document.getElementsByTagName("node");

            // Process each node
            for (int i = 0; i < nodeList.getLength(); i++) {
                // Get the current node
                org.w3c.dom.Node node = nodeList.item(i);

                // Process the node
                // Here you can perform any security-sensitive operations related to injection
                // For example, you might check if the node's text content is safe to be printed
                String nodeText = node.getTextContent();
                System.out.println(nodeText);
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}