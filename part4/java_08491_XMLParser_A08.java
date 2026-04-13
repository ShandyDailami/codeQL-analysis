import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_08491_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create the factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create the builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file
            Document doc = builder.parse(new SourceResource("input.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Print all element and attributes
            printElement(root);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element element) {
        // Print element name and attributes
        System.out.println("Element: " + element.getNodeName());
        System.out.println("Attributes: ");
        NamedNodeMap attributes = element.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node attribute = attributes.item(i);
            System.out.println("Attribute: " + attribute.getNodeName() + " = " + attribute.getTextContent());
        }

        // Print child nodes
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                printElement((Element) child);
            } else if (child.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text: " + child.getTextContent());
            }
        }
    }
}