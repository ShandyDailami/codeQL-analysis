import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class java_00188_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a new DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Setup XML Reader
            XMLReader reader = factory.newSAXReader();

            // Create a new handler
            DefaultHandler handler = new DefaultHandler();

            // Use the handler to parse the XML
            reader.setContentHandler(handler);

            // Parse the XML from file
            Document doc = reader.parse(new File("sample.xml"));

            // Get the element with the specified name
            NodeList nodes = doc.getElementsByTagName("node");

            // Print the number of nodes
            System.out.println("Number of nodes: " + nodes.getLength());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}