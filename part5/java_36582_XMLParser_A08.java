import java.io.File;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_36582_XMLParser_A08 {

    public static void main(String[] args) {

        // create a new instance of DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // parse the XML file
        Document doc = builder.parse(new File("sample.xml"));

        // get the root element of the Document
        Element root = doc.getDocumentElement();

        // create a stack to hold the parent nodes
        Stack<Element> stack = new Stack<>();

        // traverse the DOM tree
        traverse(root, stack);
    }

    private static void traverse(Element root, Stack<Element> stack) {
        // push the current element on the stack
        stack.push(root);

        // process all children of the current node
        NodeList children = root.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                // process the current node
                processNode(element, stack);
            }
        }

        // pop the current element from the stack
        stack.pop();
    }

    private static void processNode(Element node, Stack<Element> stack) {
        // print the name and value of the current node
        System.out.println("Name: " + node.getNodeName());
        System.out.println("Value: " + node.getTextContent());

        // process all parent nodes
        while (!stack.isEmpty()) {
            Element parent = stack.peek();
            NodeList children = parent.getChildNodes();
            boolean found = false;
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    Element childElement = (Element) child;
                    if (childElement.getTagName().equals(node.getTagName())) {
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                break;
            }
            stack.pop();
        }
    }
}