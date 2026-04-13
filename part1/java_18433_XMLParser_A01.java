import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_18433_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Set security manager to restrict access
            factory.setSecurityHandler(new SecurityHandlerImpl());
            
            // Create a DocumentBuilder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the XML file
            Document doc = builder.parse("example.xml");
            
            // Process the document (e.g., print all element names)
            processDocument(doc);
        } catch (Exception e) {
            System.out.println("Parsing failed: " + e.getMessage());
        }
    }
    
    private static void processDocument(Document doc) {
        // Process the document
        // This is a placeholder, you should replace this with your own code
        System.out.println("Processing document...");
    }
}