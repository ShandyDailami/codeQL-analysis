import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_07313_XMLParser_A07 {
    public static void main(String[] args) {
        // Step 1: Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Step 2: Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Use the builder to parse the XML from a file
            Document document = builder.parse("input.xml");

            // Step 4: Print out the parsed XML
            document.normalize();
            System.out.println(document.getElementsByTagName("root"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}