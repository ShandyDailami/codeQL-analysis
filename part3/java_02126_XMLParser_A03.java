import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_02126_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a factory for building a document builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the document
            Document doc = builder.parse("input.xml");

            // Process the document
            processDocument(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processDocument(Document doc) {
        // Your code here to process the XML document
    }

}