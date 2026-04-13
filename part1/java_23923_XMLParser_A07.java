import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_23923_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(new File("legacy.xml"));

            // Get the root element
            Element root = document.getDocumentElement();

            // Get all the child nodes of the root element
            NodeList nodes = root.getChildNodes();

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                // Print all the text inside the node
                if (node.getNodeType() == Node.TEXT_NODE) {
                    System.out.println(node.getNodeValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}