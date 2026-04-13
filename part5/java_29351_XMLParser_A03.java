import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_29351_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Get all child nodes
            NodeList nodes = root.getChildNodes();

            // Iterate over all child nodes
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                // If the node is an element
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Get the element name
                    String name = element.getNodeName();
                    System.out.println("Element Name: " + name);

                    // Get the element value
                    String value = element.getTextContent();
                    System.out.println("Element Value: " + value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}