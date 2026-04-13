import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_22072_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false); // Disable validation to hide possible errors
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse("src/main/resources/example.xml"); // Path to your XML file

            // Process the XML document
            // ...

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}