import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_31961_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Read XML file
            Document doc = dBuilder.parse(new File("path_to_your_xml_file.xml"));

            // Print out the XML file
            doc.getDocumentElement().normalize();
            System.out.println("XML file read successfully.");

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}