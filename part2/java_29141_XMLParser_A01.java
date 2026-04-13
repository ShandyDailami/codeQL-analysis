import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_29141_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a factory for the document builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document doc = builder.parse("src/main/resources/sample.xml");

            // Here you can add the code to handle the parsed document

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}