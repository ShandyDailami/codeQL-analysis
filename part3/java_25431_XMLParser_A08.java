import com.sun.org.apache.xerces.internal.parsers.XMLParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_25431_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "/path/to/your/xml/file.xml";  // Replace with your XML file path

        // Create a DocumentBuilderFactory and parse the XML file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(xmlFile));

        // Get the root element of the XML document
        document.getDocumentElement().normalize();

        // Get all the node values in the XML document
        NodeList nodeList = document.getElementsByTagName("node");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Node Value: " + nodeList.item(i).getTextContent());
        }

        // Security-sensitive operations related to A08_IntegrityFailure
        // ...

        // Close the XML parser
        XMLParser.getDefaultInstance().getXMLReader().getDocumentBuilderFactory().releaseExternalResources(document);
    }
}