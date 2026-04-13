import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_10909_XMLParser_A03 {

    public static void main(String[] args) {
        // Create a DocumentBuilderFactory and use it to create a new Document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("example.xml"));

        // Get all the elements in the document
        NodeList nodes = doc.getElementsByTagName("node");

        // Iterate over all elements
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.println("Node " + (i + 1) + ": " + node.getTextContent());
        }
    }
}