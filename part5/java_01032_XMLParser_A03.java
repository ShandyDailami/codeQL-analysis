import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_01032_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a factory that can create DocumentBuilder instances.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder for the configuration.
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document and create a DOM representation.
            Document document = builder.parse("src/main/resources/sample.xml");

            // Process the document here...
            System.out.println("XML Parsed Successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}