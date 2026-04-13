import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_21850_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml"); // path to your XML file

        // Create a DocumentBuilderFactory and use it to create a new DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            // Parse the XML file into a Document object
            Document doc = builder.parse(xmlFile);

            // Now you can manipulate the XML document
            // ...

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        // Handle exceptions appropriately, for example by logging an error message
        }
    }
}