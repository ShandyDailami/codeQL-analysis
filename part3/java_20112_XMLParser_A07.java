import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_20112_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml"); // Replace with your XML file path
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = null;

        try {
            document = builder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        document.getDocumentElement().normalize();
        printElement(document.getDocumentElement());
    }

    private static void printElement(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            System.out.println("Tag: " + element.getTagName());
            printAttributes(element);
            printElement(element.getFirstChild());
        }
    }

    private static void printAttributes(Element element) {
        if (element.getAttributesCount() > 0) {
            for (int i = 0; i < element.getAttributesCount(); i++) {
                System.out.println("Attribute: " + element.getAttributeNode(i).getNodeName() + " = " + element.getAttributeNode(i).getTextContent());
            }
        }
    }
}