import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_29989_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(new File("example.xml"));

            // Get all the nodes in the document
            NodeList nodes = document.getElementsByTagName("*");

            // Loop through all the nodes
            for (int i = 0; i < nodes.getLength(); i++) {
                // Get the current node
                Node node = nodes.item(i);

                // Check if the current node is an element
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    // Cast the current node to an Element
                    Element element = (Element) node;

                    // Print out the name of the element
                    System.out.println("Element: " + element.getNodeName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}