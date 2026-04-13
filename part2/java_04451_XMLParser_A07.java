import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_04451_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a factory for the DOM.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder.
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file into a Document object.
            Document doc = builder.parse(new File("input.xml"));

            // Get the root element.
            Element root = doc.getDocumentElement();

            // Get all the child nodes of the root element.
            NodeList childNodes = root.getChildNodes();

            // Iterate over each child node.
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node node = childNodes.item(i);

                // Check if the node is an element.
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    // Cast the node to an element.
                    Element element = (Element) node;

                    // Get the child node's value.
                    String value = element.getChildNodes().item(0).getNodeValue();

                    // Print the value.
                    System.out.println("Value: " + value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}