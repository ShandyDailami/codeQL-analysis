import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_15652_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the XML file
            Document document = builder.parse(new File("path_to_your_xml_file.xml"));

            // TODO: Implement security-sensitive operations with the parsed XML data

            // Print the parsed data
            System.out.println(document.getDocumentElement().getNodeName());

        } catch (IOException | SAXException | InvalidParameterException e) {
            e.printStackTrace();
        }
    }
}