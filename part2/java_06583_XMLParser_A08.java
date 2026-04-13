import java.util.Stack;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_06583_XMLParser_A08 {
    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file.xml"; // replace with your file path
        parseXML(filePath);
    }

    public static void parseXML(String filePath) {
        File file = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            document.getDocumentElement().normalize();

            printElements(document, new Stack<>());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printElements(Node node, Stack<String> stack) {
        if (node instanceof Element) {
            stack.push(node.getNodeName());
            printElements((Node) node.getChildNodes(), stack);
            stack.pop();
        } else if (node instanceof org.w3c.dom.Text) {
            System.out.println(stack + ": " + ((org.w3c.dom.Text) node).getNodeValue());
        }
    }
}