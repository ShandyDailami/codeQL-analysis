import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_36265_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Use the builder to parse the document from the File
            InputStream fis = new FileInputStream("sample.xml");
            Document doc = dBuilder.parse(fis);

            // The parsed document is stored in a DOM tree, 
            // and we can access it using DOM methods.
            System.out.println("XML Parsed Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}