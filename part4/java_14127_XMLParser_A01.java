import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_14127_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Parse the document here with security-sensitive operations.
            // For example, print all element names and attribute values:
            doc.getElementsByTagName("*").item(0).getNodeName();
            doc.getElementsByTagName("*").item(0).getAttributes().item(0).getValue();

            // More security-sensitive operations here.

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}