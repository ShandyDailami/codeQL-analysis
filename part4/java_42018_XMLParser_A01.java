import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_42018_XMLParser_A01 {
    public static void main(String[] args) {
        // Create DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Create a new DocumentBuilder using the factory
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Create a new document using the builder
        Document doc = builder.newDocument();

        try {
            // Use DocumentBuilder's methods to parse the XML file
            doc = builder.parse(new File("broken_access_control.xml"));

            // Fetch the root element
            doc.getDocumentElement().normalize();

            // Use Document's methods to fetch nodes and attributes
            NodeList nodes = doc.getElementsByTagName("node");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                // Insert your security-sensitive operations here
                System.out.println("Node " + (i + 1) + ": " + node.getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}