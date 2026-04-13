import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class java_17846_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a new document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use factory to construct a new document
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("input.xml"));

            // Normalize the document and print the extracted value
            printTagValue(document, "tagName");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printTagValue(Document document, String tagName) {
        // Find the first 'tagName' node
        NodeList nodes = document.getElementsByTagName(tagName);
        for (int i = 0; i < nodes.getLength(); i++) {
            // Get the node value and print it
            Node node = nodes.item(i);
            System.out.println("Value of node " + tagName + ": " + node.getTextContent());
        }
    }
}