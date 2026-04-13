import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_26148_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml"); // replace with your file path
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            System.out.println("XML file parsed successfully.");

        } catch (Exception e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
    }
}