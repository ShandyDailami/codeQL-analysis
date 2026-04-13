import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_15813_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file into a Document object
            Document doc = builder.parse(new File("sample.xml"));

            // Retrieve the root element
            Element root = doc.getDocumentElement();

            // Print out all the elements and their attributes
            printElementsAndAttributes(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementsAndAttributes(Node node) {
        if (node.hasChildNodes()) {
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node childNode = childNodes.item(i);
                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) childNode;
                    System.out.println("Element: " + element.getNodeName());
                    System.out.println("Attributes: ");
                    printAttributes(element);
                    printElementsAndAttributes(childNode);
                }
            }
        }
    }

    private static void printAttributes(Element element) {
        NodeList attributes = element.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node attribute = attributes.item(i);
            System.out.println(" - " + attribute.getNodeName() + "=" + attribute.getTextContent());
        }
    }
}