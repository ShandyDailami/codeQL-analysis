import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_24520_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "example.xml"; // replace with your XML file
        parseXmlFile(xmlFile);
    }

    public static void parseXmlFile(String fileName) {
        try {
            File xmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // here you can add your security-sensitive operations, for example, checking for injection

            // print the XML file
            doc.getDocumentElement().normalize();
            System.out.println("XML file was read successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}