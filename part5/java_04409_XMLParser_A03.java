import java.io.File;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_04409_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            Stack<Node> stack = new Stack<>();
            stack.push(doc);
            printNodes(doc, stack);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNodes(Node node, Stack<Node> stack) {
        if (node instanceof Element) {
            Element element = (Element) node;
            System.out.println("Element: " + element.getNodeName());

            NodeList children = element.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                stack.push(children.item(i));
            }
        }

        while (!stack.isEmpty()) {
            Node nextNode = stack.pop();
            if (nextNode instanceof Element) {
                printNodes((Element) nextNode, stack);
            } else {
                System.out.println("Attribute: " + nextNode.getNodeName() + "=" + nextNode.getTextContent());
            }
        }
    }
}