import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_13875_XMLParser_A03 {
    public static void main(String[] args) {
        // Create a factory for our XML parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML from the URL
            Document doc = builder.parse("https://example.com/test.xml");

            // Your code here that uses the document...

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}