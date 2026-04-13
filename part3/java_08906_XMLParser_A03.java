import java.io.FileInputStream;
import java.io.InputStream;
import java.security.ProtectionDomain;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_08906_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a document builder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use the builder to parse the XML from the file
            InputStream is = new FileInputStream("sample.xml");
            Document doc = builder.parse(is);

            // Now you can handle the document...

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}