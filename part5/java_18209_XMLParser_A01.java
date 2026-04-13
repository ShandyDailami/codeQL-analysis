import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_18209_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use the builder to parse the XML file into a Document
            Document doc = builder.parse(new File("example.xml"));

            // Get all the elements in the document
            NodeList nodes = doc.getElementsByTagName("*");

            // Print the name of each node
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Node: " + nodes.item(i).getNodeName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}