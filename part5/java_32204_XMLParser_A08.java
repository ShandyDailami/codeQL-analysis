import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_32204_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse("example.xml");

            // Print out the content of the XML file
            printDocumentContent(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printDocumentContent(Document doc) {
        // Get the root element of the Document
        Element root = doc.getDocumentElement();

        // Print out the content of the root element
        printElementContent(root);
    }

    private static void printElementContent(Element element) {
        // Print out the name of the current element
        System.out.println("Element: " + element.getNodeName());

        // Get the attributes of the current element
        NamedNodeMap attributes = element.getAttributes();
        if (attributes != null) {
            // Print out the content of each attribute
            for (int i = 0; i < attributes.getLength(); i++) {
                Node attribute = attributes.item(i);
                System.out.println("Attribute: " + attribute.getNodeName() + "=" + attribute.getTextContent());
            }
        }

        // Get the child nodes of the current element
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);

            // If the current node is a text node, print out its content
            if (child.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text: " + child.getTextContent());
            } else {
                // If the current node is an element node, print out its content and the content of its child nodes
                printElementContent((Element) child);
            }
        }
    }
}