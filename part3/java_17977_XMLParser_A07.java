import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_17977_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new File("path_to_your_xml_file.xml"));

            // Start parsing the document
            parseDocument(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseDocument(Document doc) {
        // Retrieve the root element
        doc.getDocumentElement().normalize();

        // Retrieve and print all child elements
        NodeList children = doc.getElementsByTagName("*");
        for (int i = 0; i < children.getLength(); i++) {
            printNodeInfo(children.item(i));
        }

        // Retrieve and print all attributes
        NodeList attributes = doc.getElementsByTagName("*");
        for (int i = 0; i < attributes.getLength(); i++) {
            printAttributeInfo(attributes.item(i));
        }

        // Retrieve and print all text nodes
        NodeList textNodes = doc.getElementsByTagName("text()");
        for (int i = 0; i < textNodes.getLength(); i++) {
            printTextInfo(textNodes.item(i));
        }
    }

    private static void printNodeInfo(org.w3c.dom.Node node) {
        System.out.println("Node Name: " + node.getNodeName());
    }

    private static void printAttributeInfo(org.w3c.dom.Node node) {
        System.out.println("Node Name: " + node.getNodeName());
        System.out.println("Node Value: " + node.getNodeValue());
    }

    private static void printTextInfo(org.w3c.dom.Node node) {
        System.out.println("Text: " + node.getTextContent());
    }
}