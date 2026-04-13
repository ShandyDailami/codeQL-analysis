import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_04806_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a factory that can build a Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false); // Disable validation
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML from a file
            Document doc = builder.parse("input.xml");

            // TODO: Handle the parsed document

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}