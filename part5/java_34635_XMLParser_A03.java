import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_34635_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Use it to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));
            // Get the root element
            Element root = doc.getDocumentElement();
            // Get all child elements
            NodeList children = root.getChildNodes();
            // Loop over all children
            for (int i = 0; i < children.getLength(); i++) {
                Node node = children.item(i);
                // If the node is an element
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    // Cast the node to an element
                    Element element = (Element) node;
                    // Print the element's tag and its text
                    System.out.println("Tag: " + element.getTagName() + ", Text: " + element.getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}