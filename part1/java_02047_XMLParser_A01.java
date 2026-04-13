import java.io.File;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_02047_XMLParser_A01 {

    public static void parse(String fileName) throws Exception {
        File file = new File(fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        Stack<Element> stack = new Stack<>();
        NodeList nodes = document.getElementsByTagName("*");

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                print(element, stack);
            }
        }
    }

    private static void print(Element element, Stack<Element> stack) {
        // Push the current element onto the stack
        stack.push(element);

        // Print the element name and attributes
        System.out.println("Element: " + element.getNodeName());
        System.out.println("Attributes:");
        System.out.println("Name: " + element.getAttribute("name"));
        System.out.println("Value: " + element.getAttribute("value"));

        // Print all child elements of the current element
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) childNode;
                print(childElement, stack);
            }
        }

        // Pop the current element from the stack
        stack.pop();
    }

    public static void main(String[] args) throws Exception {
        // Replace "example.xml" with your XML file name
        parse("example.xml");
    }
}