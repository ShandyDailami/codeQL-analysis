import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_13521_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml"); // replace with your xml file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Get the root element
            Element root = doc.getDocumentElement();

            // Traverse the XML document using a recursive function
            traverse(root, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void traverse(Node node, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            System.out.println(element.getNodeName());
            // Print attributes
            for (int i = 0; i < element.getAttributes().getLength(); i++) {
                System.out.println("    " + element.getAttributes().item(i).getNodeName() + "=" + element.getAttributes().item(i).getNodeValue());
            }
        } else {
            System.out.println(node.getNodeValue());
        }
        // Traverse children
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            traverse(children.item(i), indent + 1);
        }
    }
}