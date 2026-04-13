import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_24996_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the XML file
            Document doc = builder.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.xml"));

            // TODO: Process the parsed XML document here.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}