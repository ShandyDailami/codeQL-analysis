import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_40572_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder for handling XML documents
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input XML file
            Document doc = builder.parse("src/input.xml");

            // Process the document here
            // ...

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}