import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;

public class java_36217_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";  // your xml file path
        parseXMLFile(xmlFile);
    }

    private static void parseXMLFile(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);  // Enable validation for security sensitive operations
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(xmlFile);
        } catch (SAXException | IOException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
            return;
        }

        // Continue with your processing of the document (e.g., security sensitive operations)
        // ...

        // Print parsed XML to console for demonstration
        System.out.println(doc.getDocumentElement().getNodeName());
    }
}