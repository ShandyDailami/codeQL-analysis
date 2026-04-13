import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_04033_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file into a Document object
            Document document = builder.parse("example.xml");

            // TODO: Perform security-sensitive operations
            // ...

            // TODO: Use the Document object to access or manipulate the parsed XML data
            // ...

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}