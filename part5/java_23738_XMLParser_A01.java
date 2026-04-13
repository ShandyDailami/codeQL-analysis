import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class java_23738_XMLParser_A01 {
    private Stack<String> stack = new Stack<>();
    private Map<String, String> map = new HashMap<>();

    public void parse(String fileName) throws Exception {
        FileInputStream fis = new FileInputStream(fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(fis);
        doc.getDocumentElement().normalize();
        printElements(doc, "");
    }

    private void printElements(Node node, String indent) {
        if (node != null && node.hasChildNodes()) {
            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                Node child = node.getChildNodes().item(i);
                printElements(child, indent + "  ");
                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println(indent + "element: " + child.getNodeName() + ", attributes: " + child.getAttributes());
                }
           
        }
    }
}