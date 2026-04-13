import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_24998_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and create a new Document
            Document document = builder.parse(new File("input.xml"));

            // Get the root element of the document
            Element root = document.getDocumentElement();

            // Print out all the elements and their values
            printElementsAndValues(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementsAndValues(Node node) {
        if (node instanceof Element) {
            Element element = (Element) node;
            System.out.println("Element: " + element.getNodeName());

            // Print out all the attributes of the element
            for (int i = 0; i < element.getAttributes().getLength(); i++) {
                System.out.println("Attribute: " + element.getAttributes().item(i).getNodeName() + "=" + element.getAttributes().item(i).getTextContent());
            }

            // Recursively call printElementsAndValues for all child nodes
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                printElementsAndValues(childNodes.item(i));
            }
        }
    }
}