import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_00634_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file into a Document object
            Document doc = builder.parse(new File("input.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Print the names and values of all elements
            printElements(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Element element) {
        // Print the element's name
        System.out.println(element.getNodeName());

        // If the element has attributes
        if (element.hasAttributes()) {
            // Print all attributes
            for (int i = 0; i < element.getAttributes().getLength(); i++) {
                System.out.println(element.getAttributes().item(i).getNodeName() + " = " + element.getAttributes().item(i).getTextContent());
            }
        }

        // If the element has child nodes
        if (element.hasChildNodes()) {
            // Print all child nodes
            for (int i = 0; i < element.getChildNodes().getLength(); i++) {
                Node childNode = element.getChildNodes().item(i);
                if (childNode.getNodeType() == Node.TEXT_NODE) {
                    System.out.println("Text node: " + childNode.getNodeValue());
                } else {
                    printElements((Element) childNode);
                }
            }
        }
    }
}