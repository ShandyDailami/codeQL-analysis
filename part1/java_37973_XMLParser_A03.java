import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_37973_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, IOException {
        // Create a new factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Create a new document builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML document
        Document doc = builder.parse(new SourceResource("input.xml")); // Replace with your xml file

        // Get the root element of the document
        Element root = doc.getDocumentElement();

        // Print all elements and their attributes
        printElements(root);
    }

    private static void printElements(Element element) {
        System.out.println("Element: " + element.getNodeName());

        // Get all child nodes
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);

            // Print each child node and its attributes
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                printElements((Element) node);
            } else if (node.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text: " + node.getNodeValue());
            }
        }
    }
}