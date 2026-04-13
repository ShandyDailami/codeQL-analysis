import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_39700_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a factory for handling the XML content
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Use the factory to get the builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML content from the file
            Document doc = builder.parse(new File("example.xml"));

            // Step 4: Handle the document
            // ...

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}