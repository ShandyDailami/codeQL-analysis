import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_28961_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse("input.xml");

            // TODO: Perform security-sensitive operations related to A08_IntegrityFailure
            // ...

            // Print out the document elements and attributes
            document.getDocumentElement().normalize();
            System.out.println("Root element: " + document.getElements().getItem(0).getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}