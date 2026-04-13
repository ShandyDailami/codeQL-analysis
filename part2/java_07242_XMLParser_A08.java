import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_07242_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a factory object
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file into a Document object
            Document doc = builder.parse("input.xml");

            // Process the document here
            // ...

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}