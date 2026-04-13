import java.util.Stack;
import java.util.StringTokenizer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class java_24367_XMLParser_A01 {
    private static final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    public static void main(String[] args) {
        String xmlString = "<root><name>John</name><age>30</age></root>";
        parseXML(xmlString);
    }

    public static void parseXML(String xmlString) {
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlString)));

            printTags(document.getElementsByTagName("*"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printTags(NodeList nodes) {
        Stack<Node> stack = new Stack<>();
        stack.push(nodes.item(0));

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            System.out.println("Tag: " + node.getNodeName());

            NodeList children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                stack.push(children.item(i));
            }
        }
    }
}