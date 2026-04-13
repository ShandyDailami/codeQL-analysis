import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_27134_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("example.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Print the element names and contents
            printElements(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Element element) {
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node instanceof Element) {
                Element childElement = (Element) node;
                System.out.println("Element: " + childElement.getTagName());
                printElements(childElement);
            } else if (node instanceof Text) {
                Text textNode = (Text) node;
                System.out.println("Text: " + textNode.getNodeValue());
            }
        }
    }
}