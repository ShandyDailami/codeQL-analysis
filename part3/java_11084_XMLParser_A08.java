import java.awt.print.Book;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class java_11084_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse("src/main/resources/sample.xml");

            // Get the root element
            Element root = doc.getDocumentElement();

            // Get all child elements of the root element
            NodeList nodes = root.getChildNodes();

            // Loop through all child nodes
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Get the tag name and value
                    String tagName = element.getTagName();
                    String value = element.getTextContent();

                    System.out.println("Tag: " + tagName + ", Value: " + value);

                    // Get attributes of the element
                    Map<String, String> attributes = element.getAttributes().getNames();
                    for (String attribute : attributes) {
                        System.out.println("Attribute: " + attribute + ", Value: " + element.getAttribute(attribute));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}