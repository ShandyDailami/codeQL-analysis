import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_17520_XMLParser_A03 {

    public static void main(String[] args) {
        // Create a factory for the DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Get the DocumentBuilder for the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML from the URL
            Document document = builder.parse("https://example.com/sample.xml");

            // TODO: Implement your parser here

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}