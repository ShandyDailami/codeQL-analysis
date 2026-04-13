import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_01983_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory instance
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Step 2: Get the DocumentBuilder instance from the factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Step 3: Parse the XML file into a Document object
            Document doc = dBuilder.parse("input.xml");

            // Step 4: Process the document...
            // The following is a simple example and may not be suitable for all types of XML files.
            // In a real scenario, you would need to extract the data and process it as needed.
            String xmlContent = doc.getDocumentElement().getFirstChild().getNodeValue();
            System.out.println("XML Content: " + xmlContent);

        } catch (Exception e) {
            e.printStackTrace();
        // Step 5: Handle the exception appropriately
        }
    }
}