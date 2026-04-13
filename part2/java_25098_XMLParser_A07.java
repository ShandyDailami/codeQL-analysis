import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_25098_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("example.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Get the list of nodes
            NodeList nodes = root.getChildNodes();

            // Print the names and values of all nodes
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Node name: " + element.getNodeName());
                    System.out.println("Node value: " + element.getNodeValue());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}