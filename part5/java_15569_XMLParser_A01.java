import java.io.File;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_15569_XMLParser_A01 {

    private Stack<String> nodeStack = new Stack<>();

    public void parse(String filename) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(filename));

        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String name = element.getTagName();
                if (nodeStack.isEmpty()) {
                    System.out.println(name);
                } else {
                    printIndentation(nodeStack);
                    System.out.println(name);
                }
                nodeStack.push(name);
            } else if (node.getNodeType() == Node.ATTRIBUTE_NODE) {
                Node attrNode = node.getNextSibling();
                if (attrNode != null && attrNode.getNodeType() == Node.TEXT_NODE && ((Text) attrNode).getNodeValue().isEmpty()) {
                    printIndentation(nodeStack);
                    System.out.println("@" + element.getAttributeNode(node).getNodeName() + "=" +
                            ((Text) attrNode).getNodeValue());
                }
            }
        }
    }

    private void printIndentation(Stack<String> nodeStack) {
        while (!nodeStack.isEmpty()) {
            System.out.print("\n\t");
            nodeStack.pop();
        }
    }

    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        parser.parse("sample.xml");
    }
}