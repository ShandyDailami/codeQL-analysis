import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_02836_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory for the document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use it to create a document
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("test.xml"));

            // TODO: Add code here to process the XML document, possibly using
            //      security-sensitive operations related to A01_BrokenAccessControl.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}