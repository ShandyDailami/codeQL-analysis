import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_37470_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the XML file
            Document document = builder.parse("sample.xml");

            // TODO: Add security-sensitive operations related to A08_IntegrityFailure

            // Print the document
            document.getDocumentElement().normalize();
            System.out.println(document.getElements().getItem(0));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}