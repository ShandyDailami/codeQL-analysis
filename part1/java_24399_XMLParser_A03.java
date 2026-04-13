import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_24399_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML from a file
            Document doc = builder.parse("example.xml");

            // Print the parsed XML
            doc.getElementsByTagName("root").item(0).getTextContent();
        } catch (SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}