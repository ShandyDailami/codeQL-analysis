import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_19654_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Get DocumentBuilder from factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse XML file and store into Document object
            Document document = builder.parse(new File("sample.xml"));

            // Print out read contents of the document
            // This is done by serializing the document to a string.
            // It's not recommended to do this in a real-world application
            // Instead, you should use a more robust solution for logging or error handling
            System.out.println(document.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}