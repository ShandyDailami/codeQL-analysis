import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.apache.xml.security.keys.keyresolver.KeyResolver;
import org.apache.xml.security.keys.KeyStoreKeyResolver;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_12682_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Use the factory to create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("path_to_your_xml_file.xml"));

            // Query the XML document
            NodeList nodeList = doc.getElementsByTagName("tag_name");

            // Process the nodes
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Node " + (i + 1) + ": " + nodeList.item(i).getTextContent());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}