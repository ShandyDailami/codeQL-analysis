import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_38562_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path/to/your/file.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // No explicit access control, no user input, no system calls.
            // Here we're just using the Document object to print the XML file.
            System.out.println("XML File:\n" + doc.getDocumentElement().getNodeName());

        } catch (Exception e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
    }
}