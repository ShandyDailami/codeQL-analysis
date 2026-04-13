import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_12529_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Setup the factory
            factory.setValidating(true);
            factory.setIgnoringElementContentWhitespace(true);

            // Create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document document = builder.parse(new File("sample.xml"));

            // Get the root element
            Element root = document.getDocumentElement();

            // Print the node name and attribute
            System.out.println("Root Element : " + root.getNodeName());

            // Get and print all child nodes of the root element
            NodeList childNodes = root.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node node = childNodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Child Node : " + element.getNodeName());
                    System.out.println("Child Node Attribute : " + element.getAttribute("attr"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}