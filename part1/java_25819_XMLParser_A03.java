import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_25819_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFilePath = "/path/to/your/xml/file.xml"; // replace with your XML file path
        parseXml(xmlFilePath);
    }

    private static void parseXml(String xmlFilePath) {
        try {
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Print out the parsed XML document
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getElementsByTagName("name").item(0).getTextContent());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}