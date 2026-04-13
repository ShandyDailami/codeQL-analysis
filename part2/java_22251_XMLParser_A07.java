import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_22251_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the input file into a Document object
            Document doc = builder.parse(new File("input.xml"));
            // Retrieve the root element
            NodeList nl = doc.getElementsByTagName("root");
            Node root = nl.item(0);
            Element element = (Element) root;
            // Traverse the XML tree
            traverse(element, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void traverse(Element element, int depth) {
        // Print the current node and its depth
        System.out.print(element.getTagName() + " (" + depth + ")\n");
        // Get the list of child nodes
        NodeList children = element.getChildNodes();
        // Traverse the child nodes
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            // Check if the node is an Element
            if (node instanceof Element) {
                // Call the traverse method recursively
                traverse((Element) node, depth + 1);
            }
        }
    }
}