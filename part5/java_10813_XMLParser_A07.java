import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_10813_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Get a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML from the URL to a Document object
            Document document = builder.parse("http://example.com/test.xml");

            // TODO: Perform security sensitive operations related to A07_AuthFailure

            // Step 4: Clean up
            document.normalize();
            System.out.println(document.getElements().getItem(0).getNodeName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}