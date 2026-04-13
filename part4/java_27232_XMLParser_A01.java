import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_27232_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Step 1: Create DocumentBuilderFactory and set it up
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Use the factory to get a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Use the builder to parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // TODO: Process the parsed XML document

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}