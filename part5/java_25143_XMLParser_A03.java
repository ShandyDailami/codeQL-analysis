import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_25143_XMLParser_A03 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            // Parse the XML file
            Document document = builder.parse(new File("input.xml"));

            // Get the root element
            Element root = document.getDocumentElement();

            // Print the element name and attributes
            printElement(root, 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element element, int indentation) {
        for (int i = 0; i < indentation; i++) {
            System.out.print("  ");
        }
        System.out.println("Element: " + element.getNodeName() + ", Attributes: " + element.getAttributes());

        // Get the child nodes
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                printElement((Element) childNode, indentation + 1);
            }
        }
    }
}