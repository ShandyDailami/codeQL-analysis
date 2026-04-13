import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_27397_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Load the XML document
            File xmlFile = new File("path/to/your/xml/file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Your code here to handle the document, for example:
            String rootElement = doc.getDocumentElement().getNodeName();
            System.out.println("Root element: " + rootElement);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}