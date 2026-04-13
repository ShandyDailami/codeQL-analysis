import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_30339_XMLParser_A01 {

    public static void main(String[] args) {

        // Step 1: Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Step 2: Get a DocumentBuilder from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file and create a new Document object
            Document doc = builder.parse("src/main/resources/sample.xml");

            // Step 4: Perform security-sensitive operations related to A01_BrokenAccessControl
            // Here, we're just printing the document's root element
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}