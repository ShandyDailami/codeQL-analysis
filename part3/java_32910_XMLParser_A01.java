import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_32910_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a new factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use the builder to parse the file into a Document object
            Document doc = builder.parse(new File("sample.xml"));

            // Get all the elements in the document
            NodeList nodes = doc.getElementsByTagName("*");

            // Iterate over the elements
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                // If the node is an element (not text or comment)
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Print the element name and value
                    System.out.println("Element: " + element.getTagName());
                    System.out.println("Value: " + element.getFirstChild().getNodeValue());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}