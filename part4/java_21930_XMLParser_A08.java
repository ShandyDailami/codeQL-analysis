import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_21930_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Setup the factory
            factory.setValidating(true); // Enable validation
            factory.setNamespaceAware(true); // Enable namespaces

            // Step 3: Create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 4: Parse the XML from the file
            Document doc = builder.parse("src/main/resources/sample.xml");

            // Step 5: Print the XML content
            System.out.println(doc.getDocumentElement().getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}