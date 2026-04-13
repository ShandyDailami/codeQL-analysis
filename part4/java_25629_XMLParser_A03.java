import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_25629_XMLParser_A03 {

    private Stack<String> namespaceStack = new Stack<>();
    private Map<String, String> namespaceMap = new HashMap<>();

    public void parse(String file) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream is = new FileInputStream(file);
        Document doc = builder.parse(is);
        doc.getDocumentElement().normalize();
        printElement(doc.getDocumentElement());
    }

    private void printElement(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            String name = element.getNodeName();
            String value = element.getAttribute("value");
            System.out.println(name + " = " + value);
            NodeList children = element.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                printElement(children.item(i));
            }
        }
    }

    public static void main(String[] args) {
        try {
            new XmlParser().parse("sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}