import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_21657_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Set security manager
            factory.setValidating(true);
            factory.setFeature("http://xml.org/sax/features/external-parsed-entity", true);

            // Create a DocumentBuilder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the document
            Document document = builder.parse(new File("yourfile.xml"));

            // TODO: Your code here.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}