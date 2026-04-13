import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_16698_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));
            
            // Get the root element of the document
            NodeList nodes = doc.getElementsByTagName("sample");
            
            // Iterate over all "sample" elements
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                // Here, we are using a basic sanitization method.
                // In a real-world scenario, you would need a more complex sanitization method.
                String sanitizedNode = sanitizeNode(node.getTextContent());
                System.out.println(sanitizedNode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // This function is a basic sanitization method.
    // In a real-world scenario, you would need a more complex sanitization method.
    private static String sanitizeNode(String node) {
        // Remove dangerous characters
        String sanitizedNode = node.replace("<", "&lt;").replace(">", "&gt;");
        return sanitizedNode;
    }
}