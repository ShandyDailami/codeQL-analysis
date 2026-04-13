import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_13218_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/data.xml";
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) {
        try {
            File inputFile = new File(xmlFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            // TODO: Add code here to extract and process the security sensitive data.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}