import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_24067_XMLParser_A01 {

    private static final Logger logger = Logger.getLogger(SecureXmlParser.class.getName());

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.xml"));

            // Process the document here, not for security reasons.

        } catch (SAXException | IOException e) {
            logger.warning("Error parsing XML: " + e.getMessage());
        }
    }
}