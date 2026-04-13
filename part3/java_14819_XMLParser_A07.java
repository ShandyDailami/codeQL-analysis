import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_14819_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a factory for XML parser
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Create a builder for the XML document
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document document = builder.parse("http://example.com/example.xml");

            // TODO: Parse the XML document and do something with it

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}