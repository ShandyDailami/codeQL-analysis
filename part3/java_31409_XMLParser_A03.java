import java.io.File;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_31409_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            printTagsAndAttributes(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printTagsAndAttributes(org.w3c.dom.Document doc) {
        Stack<Node> stack = new Stack<>();
        stack.push(doc.getDocumentElement());
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node instanceof Element) {
                Element element = (Element) node;
                System.out.println("Tag: " + element.getTagName());
                NodeList attributes = element.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    Node attribute = attributes.item(i);
                    System.out.println("Attribute: " + attribute.getNodeName() + "=" + attribute.getTextContent());
                }
                stack.push(element.getFirstChild());
            }
        }
    }
}