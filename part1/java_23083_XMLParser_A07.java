import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_23083_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and use it to create a Document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Get the root element
            Element rootElement = doc.getDocumentElement();

            // Print out all element names and values
            printElement(rootElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element element) {
        System.out.println("Element name: " + element.getNodeName());
        System.out.println("Element value: " + element.getNodeValue());

        // Get all child nodes
        List<Node> childNodes = Arrays.asList(element.getChildNodes());

        // Print out all child node names and values
        for (Node childNode : childNodes) {
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                printElement((Element) childNode);
            } else if (childNode.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Child node value: " + childNode.getNodeValue());
            }
        }
    }
}