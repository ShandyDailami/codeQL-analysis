import java.io.File;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_19673_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            printElements(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        Stack<Node> stack = new Stack<>();
        stack.push(doc);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node instanceof Element) {
                Element element = (Element) node;
                System.out.println("Element name: " + element.getTagName());
                if (element.getAttributes().getLength() > 0) {
                    stack.push(element);
                }
            }
        }
    }
}