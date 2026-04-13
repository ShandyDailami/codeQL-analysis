import com.sun.org.apache.xpath.internal.dom.NodeListImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_22271_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            printElement(doc.getDocumentElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            System.out.println("Element Name: " + element.getNodeName());
            printAttributes(element);
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); ++i) {
                printElement(childNodes.item(i));
            }
        }
    }

    private static void printAttributes(Element element) {
        System.out.println("Attributes of Element: ");
        for (int i = 0; i < element.getAttributes().getLength(); ++i) {
            System.out.println("Attribute Name: " + element.getAttributes().item(i).getNodeName() + " = " + element.getAttributes().item(i).getTextContent());
        }
    }
}