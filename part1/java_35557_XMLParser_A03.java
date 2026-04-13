import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_35557_XMLParser_A03 {
    public static void main(String[] args) {
        // Load the XML file
        File xmlFile = new File("path/to/your/file.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }

        // Security-sensitive operations
        // Here, I am just printing the XML content for the sake of simplicity
        System.out.println("XML content: " + doc.getDocumentElement().getFirstChild().getNodeValue());
    }
}