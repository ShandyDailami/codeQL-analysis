import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_31285_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            File xmlFile = new File("path_to_your_file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // TODO: Add your code here to parse the XML document
            // Example: Print out the name of each element in the document
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}