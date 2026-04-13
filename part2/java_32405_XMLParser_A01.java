import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_32405_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create DocumentBuilderFactory instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create DocumentBuilder instance
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse XML document from input stream
            InputStream inputStream = new FileInputStream("input.xml");
            Document doc = builder.parse(inputStream);

            // TODO: Add code to parse XML document and access data.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}