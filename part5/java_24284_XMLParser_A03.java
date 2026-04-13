import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_24284_XMLParser_A03 {
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
            NodeList list = root.getChildNodes();
            // Loop through each child node
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                // Print out the node's name and value
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Tag: " + element.getTagName() + ", Value: " + element.getFirstChild().getNodeValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}