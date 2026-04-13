import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_12406_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Step 2: Use the factory to create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Step 3: Use the builder to parse the XML file
            Document doc = builder.parse(new File("input.xml"));
            
            // Step 4: Use the DOM (Document Object Model) to traverse the XML file
            printElements(doc);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc) {
        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            printElement(nodes.item(i));
        }
    }

    private static void printElement(Node node) {
        if (node instanceof Element) {
            Element element = (Element) node;
            System.out.println("Element: " + element.getTagName());
            NodeList attributes = element.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                Node attribute = attributes.item(i);
                System.out.println("Attribute: " + attribute.getNodeName() + "=" + attribute.getTextContent());
            }
        }
    }
}