import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_31371_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a document builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file and create a new document
            Document doc = builder.parse("brokenaccess.xml");

            // TODO: Insert code to handle the document here

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}