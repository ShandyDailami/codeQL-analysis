import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_09468_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder for handling XML content
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input XML file and turn it into a Document object
            Document doc = builder.parse("input.xml");

            // Get the root element
            Element root = doc.getDocumentElement();

            // Traverse the XML tree and print out the name and value of each tag
            traverse(root);

        } catch (Exception e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }

    private static void traverse(Element node) {
        // Print the name and value of the current node
        System.out.println("Tag: " + node.getTagName() + ", Value: " + node.getFirstChild().getNodeValue());

        // If the node has child nodes, traverse them
        for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
            if (child instanceof Element) {
                traverse((Element) child);
            }
        }
    }
}