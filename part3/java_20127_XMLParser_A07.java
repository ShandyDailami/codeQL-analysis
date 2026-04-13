import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_20127_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("input.xml"));

            // Get the root element
            doc.getDocumentElement().normalize();

            // Print all element names and attributes
            printElement(doc, doc.getDocumentElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Document doc, Element element) {
        System.out.println("Element: " + element.getNodeName());

        // Print all attributes
        NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            Node attr = attrs.item(i);
            System.out.println("Attribute: " + attr.getNodeName() + " = " + attr.getTextContent());
        }

        // Print child nodes
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                printElement((Document) doc, (Element) child);
            } else if (child.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text: " + child.getNodeValue());
            }
        }
    }
}