import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_28093_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Allow all Saxon DTD/XDR: allow external DTD/XDR
            factory.setFeature("http://xml.apache.org/xsl/security/trusted.feature", true);

            // Create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse("sample.xml");

            // TODO: Process the XML document (e.g., integrity check)

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}