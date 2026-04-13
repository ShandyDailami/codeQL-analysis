import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_08655_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a factory for the XML parser
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Create a builder based on the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file
            Document doc = builder.parse(new File("example.xml"));

            // You can now process the XML document here...

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}