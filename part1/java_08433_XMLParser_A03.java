import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;

public class java_08433_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse("src/sample.xml");

            // Handle document here
            // ...

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}