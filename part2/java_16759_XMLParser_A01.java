import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_16759_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder using the factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the input file into a Document object
            Document doc = dBuilder.parse(new File("input.xml"));

            // Get the root element of the document
            Element rootElement = doc.getDocumentElement();

            // Get all the child nodes
            NodeList childNodes = rootElement.getChildNodes();

            // Process all the child nodes
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node node = childNodes.item(i);

                // Print the node name and content
                System.out.println("Node Name: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Element content: " + element.getFirstChild().getNodeValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}