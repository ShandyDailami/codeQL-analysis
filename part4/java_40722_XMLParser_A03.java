import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_40722_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory and use it to create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 2: Use the DocumentBuilder's buildDocument method to create a Document from an XML file
            Document document = builder.parse("src/main/resources/sample.xml");

            // Step 3: Use the Document's getElementsByTagName method to get the first element with the tag name "username"
            NodeList nodes = document.getElementsByTagName("username");

            // Step 4: Handle the security-sensitive operations related to injection by validating and sanitizing the input
            // In this example, we'll just log the sanitized username
            String sanitizedUsername = sanitizeInput(nodes.item(0).getTextContent());
            System.out.println("Sanitized username: " + sanitizedUsername);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String sanitizeInput(String input) {
        // Implement your own sanitization logic here
        // For now, we'll just return the input as is
        return input;
    }
}