import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_39154_XMLParser_A08 {

    public static void main(String[] args) {

        // Create DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(getFileAsStream("sample.xml"));

            // Print the XML file
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static InputStream getFileAsStream(String file) {
        try {
            return new FileInputStream(file);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}