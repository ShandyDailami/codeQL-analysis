import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidParameterException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_31964_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "example.xml"; // replace with your xml file
        parseXMLFile(xmlFile);
    }

    public static void parseXMLFile(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document;
        try {
            document = builder.parse(new File(xmlFile));
        } catch (IOException e) {
            throw new InvalidParameterException("XML file not found or not readable", e);
        }

        // Normalize the document to ensure that it is always in a valid state
        document.getDocumentElement().normalize();

        printElement(document, document.getDocumentElement());
    }

    public static void printElement(Document document, Element element) {
        System.out.println("Element: " + element.getNodeName());

        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                printElement((Document) document, (Element) node);
            } else if (node.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Value: " + node.getNodeValue());
            }
        }
    }
}