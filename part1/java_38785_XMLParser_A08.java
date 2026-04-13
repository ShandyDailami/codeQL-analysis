import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_38785_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        parseXML(xmlFile);
    }

    public static void parseXML(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Perform security-sensitive operations related to integrity failures here
            // e.g., check for XSS attacks, SQL injection attacks etc.

            // Print out the parsed XML content
            System.out.println(doc.getDocumentElement().getNodeName());

        } catch (SAXException | IOException e) {
            System.out.println("Failed to parse XML file: " + xmlFile.getName());
            e.printStackTrace();
        }
    }
}