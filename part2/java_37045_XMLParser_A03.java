import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class java_37045_XMLParser_A03 {

    public static void main(String[] args) {
        String fileName = "src/main/resources/example.xml"; // provide your xml file here
        parseXML(fileName);
    }

    public static void parseXML(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fileName);

            // Removing the following line for security-sensitive operations

            // System.out.println("XML Parsed Successfully!");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Error in parsing the XML file. " + e.getMessage());
        }
    }
}