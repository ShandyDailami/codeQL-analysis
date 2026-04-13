import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_16411_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("input.xml"));

            // Retrieve the root element
            Element rootElement = doc.getDocumentElement();

            // Print all element names and their values
            printElement(rootElement);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element element) {
        System.out.println("Tag: " + element.getTagName());

        // If the element has attributes
        if (element.hasAttributes()) {
            NamedNodeMap attributes = element.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                Node attribute = attributes.item(i);
                System.out.println("Attribute: " + attribute.getNodeName() + " = " + attribute.getTextContent());
            }
        }

        // If the element has children
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                printElement((Element) node);
            } else if (node.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text: " + node.getTextContent());
            }
        }
    }
}