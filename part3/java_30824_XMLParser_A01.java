import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_30824_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create DocumentBuilderFactory instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Get DocumentBuilder instance
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse XML file and load into Document object
            Document doc = builder.parse(new File("path_to_your_xml_file.xml"));

            // TODO: Add code here to handle the parsed document securely

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}