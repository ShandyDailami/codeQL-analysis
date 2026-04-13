import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_05470_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true); // enable validation

            // Create a builder for building a document
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(new File("input.xml"));

            // Process the document here
            // ...

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}