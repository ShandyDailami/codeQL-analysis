import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_38865_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and use it to create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use the DocumentBuilder to read an XML file and convert it to a Document object
            Document doc = builder.parse(new FileInputStream("sample.xml"));

            // Security-sensitive operation: No Injection
            // You can insert any string into the Document object to create a new node
            doc.createElement("injection");

            // Save the document
            doc.getDocumentElement().normalize();
            doc.write(System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}