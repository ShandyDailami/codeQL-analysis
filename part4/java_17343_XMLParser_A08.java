import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_17343_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Get the DocumentBuilder from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("input.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Get the list of nodes in the root element
            NodeList nodes = root.getChildNodes();

            // Loop over the nodes
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    // Get the element
                    Element elem = (Element) node;

                    // Get the name of the node
                    String nodeName = elem.getNodeName();

                    // Get the value of the node
                    String nodeValue = elem.getFirstChild().getNodeValue();

                    // Print the node name and value
                    System.out.println("Node Name: " + nodeName + ", Node Value: " + nodeValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}