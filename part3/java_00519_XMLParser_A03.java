import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_00519_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML
            Document doc = builder.parse(Main.class.getResourceAsStream("/example.xml"));

            // TODO: Handle the parsed XML here.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}