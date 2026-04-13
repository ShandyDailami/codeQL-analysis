import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_00334_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Use the factory to create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Use the builder to parse the XML
            Document doc = builder.parse("input.xml");

            // Step 4: Do something with the document
            System.out.println("Document parsed successfully.");

        } catch (Exception e) {
            System.out.println("Error parsing the XML: " + e.getMessage());
        }
    }
}