import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_26958_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(new File("path_to_your_xml_file.xml"));

            // Get all elements in the document
            NodeList nodes = document.getElementsByTagName("node");

            // Iterate over each node
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                // Print out the node's value
                System.out.println("Node " + (i + 1) + ": " + node.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}