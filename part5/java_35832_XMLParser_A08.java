import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_35832_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the XML document
            Document doc = builder.parse("input.xml");

            // TODO: Handle the document, for example, print the XML elements and attributes
            // ...

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}