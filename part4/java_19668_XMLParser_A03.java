import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_19668_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("example.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Get all elements
            NodeList nodes = root.getChildNodes();

            // Iterate through all nodes
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                // Check if the node is an element
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Print the name of the element
                    System.out.println("Name: " + element.getNodeName());

                    // Print the value of the element
                    System.out.println("Value: " + element.getTextContent());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}