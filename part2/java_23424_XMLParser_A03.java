import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_23424_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use factory to create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use builder to parse the XML file
            Document doc = builder.parse(new File("path_to_your_xml_file.xml"));

            // Get all elements in the document
            NodeList nodes = doc.getElementsByTagName("tag_name");

            // Iterate through the list
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                // Do the security-sensitive operations related to injection here
                // ...
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}