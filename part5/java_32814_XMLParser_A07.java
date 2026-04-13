import java.io.File;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_32814_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml"); // Replace with your xml file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(xmlFile);
            doc.getDoctype();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Stack<Node> stack = new Stack<>();
        stack.push(doc);
        printNode(doc, stack);
    }

    private static void printNode(Node node, Stack<Node> stack) {
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            Node child = node.getChildNodes().item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                stack.push(child);
                printNode(child, stack);
            }
        }

        while (!stack.isEmpty()) {
            Node popped = stack.pop();
            if (stack.isEmpty()) {
                System.out.println("Tag: " + popped.getNodeName() + ", Value: " + popped.getTextContent());
            } else {
                System.out.print("Child of " + popped.getNodeName() + ", ");
            }
        }
    }
}