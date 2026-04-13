import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_30430_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Get a DocumentBuilderFactory instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Get a DocumentBuilder instance
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document doc = builder.parse(new File("sample.xml"));

            // Get all the elements in the document
            NodeList nodes = doc.getElementsByTagName("node");

            // Iterate through all the nodes
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                // Print out the value of the node
                System.out.println("Node " + (i + 1) + ": " + node.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}