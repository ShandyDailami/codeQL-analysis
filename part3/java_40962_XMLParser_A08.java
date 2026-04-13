import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class java_40962_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            parse("input.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parse(String file) throws ParserConfigurationException, SAXException, IOException {
        // Create a new factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Get the DocumentBuilder for the factory
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the input file into a Document object
        Document doc = builder.parse(new File(file));

        // Get the root element
        Element root = doc.getDocumentElement();

        // Print all elements in the document
        printElements(root);
    }

    private static void printElements(Element root) {
        // Print element information
        System.out.println("Element: " + root.getNodeName());

        // Print attributes
        if (root.hasAttributes()) {
            NodeList attrs = root.getAttributes();
            for (int i = 0; i < attrs.getLength(); i++) {
                System.out.println("Attribute: " + attrs.item(i).getNodeName() + "= " + attrs.item(i).getTextContent());
            }
        }

        // Print children
        NodeList children = root.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printElements((Element) children.item(i));
        }
    }
}