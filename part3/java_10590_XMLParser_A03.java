import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_10590_XMLParser_A03 {

    public static void main(String[] args) {
        String filePath = "/path/to/your/xml/file"; // Replace with your file path
        parseXMLFile(filePath);
    }

    private static void parseXMLFile(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true); // Enable validation
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(new File(filePath));

            // Process the XML document...

        } catch (Exception e) {
            e.printStackTrace();
       
        }
    }
}