import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_30415_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("path_to_your_xml_file.xml"));

            // Start parsing the XML
            parseDocument(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseDocument(Document doc) {
        // Get the root element
        Element rootElement = doc.getDocumentElement();

        // Get all the child nodes
        NodeList childNodes = rootElement.getChildNodes();

        // Loop through all the child nodes
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);

            // For security-sensitive operations, perform operations here.
            // For example, check if the node is a direct child of the root element.
            if (node.getNodeName().equals(rootElement.getNodeName())) {
                System.out.println("Access to the XML file is restricted.");
            }

            // Recursively call the parseDocument method for each child node
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                parseDocument((Element) node);
            }
        }
    }
}