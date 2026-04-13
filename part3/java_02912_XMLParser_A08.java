import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_02912_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Load XML file
            InputStream inputStream = new FileInputStream("src/sample.xml");
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(inputStream);

            // Start at the root of the document
            Element root = doc.getDocumentElement();
            parseNode(root);

            inputStream.close();
        } catch (Exception e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }

    private static void parseNode(Node node) {
        // Check if the node is a text node
        if (node.getNodeType() == Node.TEXT_NODE) {
            // Check if the text node is empty
            String text = node.getTextContent();
            if (!text.trim().isEmpty()) {
                // Perform security-sensitive operations related to A08_IntegrityFailure
                // For simplicity, we just print the text node
                System.out.println("Text node: " + text);
            }
        } else {
            // Check if the node has child nodes
            if (node.getChildNodes().getLength() > 0) {
                // For each child node, recursively call parseNode
                for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                    parseNode(node.getChildNodes().item(i));
                }
            }
        }
    }
}