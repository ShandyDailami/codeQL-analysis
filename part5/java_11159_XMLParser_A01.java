import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.xml.parsers.DocumentBuilderFactory;
import java.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_11159_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            parseXmlFile(xmlFile);
        } catch (Exception e) {
            System.out.println("Failed to parse XML file: " + e.getMessage());
        }
    }

    public static void parseXmlFile(File xmlFile) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try (InputStream xmlContent = new FileInputStream(xmlFile)) {
            Document doc = dBuilder.parse(xmlContent);

            // TODO: Add your code here to parse the XML document
            // e.g., print out all element names and text

            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        } catch (SAXException | IOException e) {
            throw new Exception("Failed to parse XML file: " + e.getMessage());
        }
    }
}