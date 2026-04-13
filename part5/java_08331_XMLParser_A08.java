import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_08331_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a factory for reading the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use it to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Read the XML file
            Document document = builder.parse(new File("input.xml"));

            // Get the root element
            Element root = document.getDocumentElement();

            // Print out all the elements and their content
            printElements(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Element element) {
        // Get the node list
        NodeList nodes = element.getChildNodes();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            // If the node is an element
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) node;

                // Print out the element and its content
                System.out.println("Element: " + childElement.getNodeName());
                System.out.println("Content: " + childElement.getFirstChild().getNodeValue());
            }
        }
    }
}