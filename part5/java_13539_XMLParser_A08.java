import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_13539_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Use the factory to create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Use the builder to parse the XML file
            Document doc = builder.parse("sample.xml");

            // Step 4: Handle the document
            System.out.println("XML file was successfully parsed.");

        } catch (Exception e) {
            System.out.println("Failed to parse the XML file: " + e.getMessage());
        }
    }
}