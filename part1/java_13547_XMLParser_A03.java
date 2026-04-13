import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_13547_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(XmlParser.class.getResourceAsStream("/example.xml"));

            // TODO: Process the parsed XML document

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}