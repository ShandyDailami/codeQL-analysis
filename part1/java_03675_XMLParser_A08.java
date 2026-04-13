import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_03675_XMLParser_A08 {
    public static void main(String[] args) {
        // Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create a DocumentBuilder with the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create a new Document object from the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Print out the XML file elements
            doc.getElementsByTagName("root").item(0).getTextContent();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}