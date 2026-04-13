import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_17757_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        parseXMLFile(xmlFile);
    }

    private static void parseXMLFile(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // TODO: Process the parsed XML document here.
            // e.g., print all element names, attribute values, etc.

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        // Handle exceptions appropriately (e.g., log error, show user a message, etc.)
        }
    }
}