import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class java_31427_XMLParser_A08 {

    public static void main(String[] args) {
        // Create the DocumentBuilder factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create the DocumentBuilder from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("legacy.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Process the root element
            processElement(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processElement(Element element) {
        // Get the element name
        String name = element.getNodeName();

        // Get the element attributes
        List<Node> attributes = new ArrayList<>();
        attributes.addAll(element.getAttributes());

        // Get the child nodes
        NodeList childNodes = element.getChildNodes();

        // Process the child nodes
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                processElement((Element) childNode);
            } else if (childNode.getNodeType() == Node.TEXT_NODE) {
                // Process text node
                System.out.println(name + ": " + childNode.getNodeValue());
            }
        }
    }
}