import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_22895_XMLParser_A07 {

    public static void main(String[] args) {

        try {
            // Create a factory for building a Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML from the file into a Document
            Document doc = builder.parse(new File("sample.xml"));

            // Retrieve the root element
            Element root = doc.getDocumentElement();

            // Print all elements in the document
            printElements(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Element element) {
        // Print the element's name
        System.out.println("Element: " + element.getNodeName());

        // Get the element's attributes
        if (element.hasAttributes()) {
            System.out.print("Attributes: ");
            NodeList attributes = element.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                Node attribute = attributes.item(i);
                System.out.print(attribute.getNodeName() + "=" + attribute.getTextContent());
            }
        }

        // Print the element's child nodes
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                printElements((Element) child);
            } else if (child.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text: " + child.getTextContent());
            }
        }
    }
}