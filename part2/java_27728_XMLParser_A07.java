import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_27728_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_file.xml");

            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the xml file into a Document object
            Document doc = dBuilder.parse(xmlFile);

            // Print out the parsed XML data
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}