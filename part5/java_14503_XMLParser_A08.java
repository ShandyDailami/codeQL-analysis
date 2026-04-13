import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_14503_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder from the factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file into a Document object
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Get all the elements in the document
            NodeList nodeList = doc.getElementsByTagName("*");

            // Print out the elements and attributes
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                // If the node is an element
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Element: " + element.getTagName());
                    System.out.println("Attributes: " + element.getAttributes().getLength());

                    // If the element has attributes
                    for (int j = 0; j < element.getAttributes().getLength(); j++) {
                        Node attribute = element.getAttributes().item(j);
                        System.out.println("Attribute: " + attribute.getNodeName() + " = " + attribute.getTextContent());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}