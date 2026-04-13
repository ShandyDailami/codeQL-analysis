import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_00301_XMLParser_A03 {

    public static void main(String[] args) {
        String fileName = "src/main/resources/example.xml";
        parseFile(fileName);
    }

    public static void parseFile(String fileName) {
        File xmlFile = new File(fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Do some security-sensitive operations related to A03_Injection
            // For example, XML External Entities (XXE)
            // More operations can be performed here...

            System.out.println("XML Parsed Successfully.");
        } catch (SAXException | IOException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
       
        }
    }
}