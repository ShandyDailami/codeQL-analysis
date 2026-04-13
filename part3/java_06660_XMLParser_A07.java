import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_06660_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Step 1: Get a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Get a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file
            Document doc = builder.parse("src/main/resources/authFailure.xml");

            // Step 4: Process the document
            // Implementation dependent on the specific requirement
            // Here, we just print the XML content
            printXMLDocument(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printXMLDocument(Document doc) {
        System.out.println(doc.getDocumentElement().getNodeName());
    }
}