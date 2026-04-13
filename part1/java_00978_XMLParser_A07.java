import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_00978_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        parseXml(xmlFile);
    }

    private static void parseXml(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            Element root = document.getDocumentElement();
            System.out.println("Root element: " + root.getNodeName());

            // Security-sensitive operations related to authentication failures
            // ...

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}