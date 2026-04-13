import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_20408_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a new instance of the DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file into a Document object
            Document doc = builder.parse(new File("input.xml"));

            // Get the root element of the Document
            Element root = doc.getDocumentElement();

            // Print the names and values of all the elements and attributes
            printElement(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element element) {
        // Print the name and value of the element
        System.out.println("Element: " + element.getNodeName());

        // Get the attributes of the element
        NamedNodeMap attributes = element.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            // Print the name and value of each attribute
            System.out.println("Attribute: " + attributes.item(i).getNodeName() + " = " + attributes.item(i).getTextContent());
        }

        // Get the children of the element
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            // If the child is an element, print it
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                printElement((Element) children.item(i));
            }
        }
    }
}