import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_33474_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");  // Replace with your XML file path
        parseXML(xmlFile);
    }

    private static void parseXML(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(xmlFile);
            System.out.println("XML File successfully parsed");
            // Perform security sensitive operations here such as checking for broken access control
            // ...

        } catch (SAXException | IOException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
    }
}