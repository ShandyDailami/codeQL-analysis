import java.util.Stack;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_03487_XMLParser_A01 {
    private Stack<Element> stack;
    private DocumentBuilder builder;

    public java_03487_XMLParser_A01() {
        stack = new Stack<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parse(String file) {
        Document doc;
        try {
            doc = builder.parse(new File(file));
            Element root = doc.getDocumentElement();
            System.out.println("Root Element: " + root.getNodeName());

            parseNode(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseNode(Node node) {
        stack.push(node);

        if (node instanceof Element) {
            Element el = (Element) node;
            System.out.println("Node name: " + el.getNodeName());
            System.out.println("Node content: " + el.getChildNodes());

            NodeList children = el.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                parseNode(children.item(i));
            }
        }

        stack.pop();
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parse("src/main/resources/sample.xml");
    }
}