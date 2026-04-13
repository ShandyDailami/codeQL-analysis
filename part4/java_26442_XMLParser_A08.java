import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

public class java_26442_XMLParser_A08 {
    public static void main(String[] args) {
        // Create a factory for the parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Create a parser
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML file
        try {
            Document document = builder.parse(new File("input.xml"));

            // Get the root element
            Element root = document.getDocumentElement();

            // Print out the names and values of all elements
            printElements(root);

            // Close the connection to the XML file
            document.close();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Element element) {
        // Check for integrity failure
        if (element.getNodeType() == Node.COMMENT_NODE) {
            System.out.println("A08_IntegrityFailure - Reopening the connection to the XML file");
            // Reopen the connection here, if necessary
        }

        // Print out the element's name and value
        System.out.println("Element: " + element.getNodeName());
        System.out.println("Value: " + element.getFirstChild().getNodeValue());

        // Get all children of the element
        NodeList children = element.getChildNodes();

        // Print out the names and values of all children
        for (int i = 0; i < children.getLength(); i++) {
            printElements((Element) children.item(i));
        }
    }
}