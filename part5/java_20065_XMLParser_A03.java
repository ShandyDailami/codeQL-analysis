import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_20065_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Get a DocumentBuilderFactory instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Get a DocumentBuilder instance
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("example.xml"));

            // Print the parsed document
            System.out.println(doc);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}