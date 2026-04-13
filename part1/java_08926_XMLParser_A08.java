import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_08926_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Use factory to create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Use builder to parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // TODO: Process the XML document

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}