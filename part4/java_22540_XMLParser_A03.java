import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_22540_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Get the XML file
            File xmlFile = new File("myfile.xml");

            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use factory to create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use builder to read the XML file
            Document doc = builder.parse(xmlFile);

            // Get the list of nodes
            NodeList nodeList = doc.getElementsByTagName("node");

            // Iterate over the list of nodes
            for (int i = 0; i < nodeList.getLength(); i++) {
                // Access the current node
                Node node = nodeList.item(i);

                // Get the text content of the current node
                String nodeText = node.getTextContent();

                // Perform security-sensitive operations related to injection
                // For example, perform SQL injection attack
                // Here, we just print the text content of the node
                System.out.println("Node " + (i + 1) + ": " + nodeText);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}