import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_15003_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document doc = builder.parse(Class.forName("sample.xml").getResourceAsStream("sample.xml"));

            // TODO: Process the document object here.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}