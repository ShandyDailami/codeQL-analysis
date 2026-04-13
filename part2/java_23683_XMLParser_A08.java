import java.util.Stack;
import java.util.StringTokenizer;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_23683_XMLParser_A08 {
    private Stack<String> elementStack;
    private String currentElement;

    public java_23683_XMLParser_A08() {
        elementStack = new Stack<String>();
    }

    public void parse(String filename) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(filename));

            doc.getDocumentElement().normalize();
            printElement("", doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printElement(String indent, Document doc) {
        NodeList childNodes = doc.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                currentElement = element.getTagName();
                System.out.println(indent + currentElement);
                elementStack.push(currentElement);

                printElement(indent + "  ", element);

                elementStack.pop();
                currentElement = elementStack.peek();
            }
       
            if (node.getNodeType() == Node.TEXT_NODE) {
                Text text = (Text) node;
                System.out.println(indent + "TEXT: " + text.getNodeValue());
            }
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parse("input.xml");
    }
}