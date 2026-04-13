import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_20768_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse("input.xml"); // replace with your xml file

            // Process the document here
            processDocument(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processDocument(Document doc) {
        // Add your code here to process the document
    }
}