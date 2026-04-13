import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_31509_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml"); // your xml file path
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Here, you can add your security-sensitive operations
            // such as checking for broken access control.

            System.out.println("Document loaded successfully.");

        } catch (SAXException | IOException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }
}