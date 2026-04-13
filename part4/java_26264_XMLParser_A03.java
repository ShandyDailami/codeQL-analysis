import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;

public class java_26264_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a factory for the DOM.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder using the factory.
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file.
            Document doc = builder.parse(new File("input.xml"));

            // Get the root element.
            Element root = doc.getDocumentElement();

            // Print all element nodes.
            printElement(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element element) {
        System.out.println("Element: " + element.getNodeName());

        // Get child elements.
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printElement((Element) children.item(i));
        }
    }
}