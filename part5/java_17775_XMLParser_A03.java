import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_17775_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load XML file
            InputStream inputStream = new FileInputStream("example.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputStream);

            // Start of security-sensitive operations
            // A01_DenialOfService
            // ...

            // A02_XMLExternalEntity
            // ...

            // A03_Injection
            // ...

            // ...
            // End of security-sensitive operations

            // Print parsed XML
            System.out.println(doc.getDocumentElement().getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}