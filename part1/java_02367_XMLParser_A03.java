import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_02367_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFilePath = "/path/to/your/xml/file.xml";  // provide your XML file path
        parseXMLFile(xmlFilePath);
    }

    public static void parseXMLFile(String xmlFilePath) {
        try {
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Perform security-sensitive operations here
            // This is a placeholder for your implementation
            String xmlContent = doc.getElements().toString();
            System.out.println(xmlContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}