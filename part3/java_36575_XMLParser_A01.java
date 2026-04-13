import java.io.InputStream;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_36575_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Load the XML file
            URL url = new URL("http://example.com/sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream in = url.openStream();
            
            Document doc = builder.parse(in);
            
            // Print out the content
            System.out.println("XML content:");
            printXml(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printXml(Document doc) {
        // Print out the content recursively
        printXmlElement(doc.getDocumentElement());
    }

    private static void printXmlElement(org.w3c.dom.Element element) {
        // Print out the element and its children
        System.out.println(element.getNodeName() + ": " + element.getTextContent());
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            printXmlElement((org.w3c.dom.Element) element.getChildNodes().item(i));
        }
    }

}