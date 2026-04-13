import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_24608_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input from a file, load into a Document
            Document doc = builder.parse("input.xml");

            // TODO: Process the document, e.g., print out all element and attribute data

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}