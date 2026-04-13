import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_15095_XMLParser_A01 {
    public static void main(String[] args) {
        // Step 1: Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Step 2: Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML document
            Document doc = builder.parse("src/test.xml");

            // TODO: Security-sensitive operations related to A01_BrokenAccessControl
            // Step 4: Print the parsed XML document
            System.out.println(doc.getDocumentElement().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}