import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_22810_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a factory for the document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(new File("sample.xml"));

            // Get the root element
            Element root = document.getDocumentElement();

            // Print all element names and their values
            printElement(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element element) {
        System.out.println("Element name: " + element.getNodeName());

        // Print all attributes
        NodeList attributes = element.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node attribute = attributes.item(i);
            System.out.println("Attribute: " + attribute.getNodeName() + "=" + attribute.getTextContent());
        }

        // Print all children
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                printElement((Element) child);
            } else if (child.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text: " + child.getTextContent());
            }
        }
    }
}