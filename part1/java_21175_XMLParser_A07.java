import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_21175_XMLParser_A07 {

    public static void main(String[] args) {
        parseXML("src/test.xml");
    }

    public static void parseXML(String filename) {
        File file = new File(filename);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            // Get the root element
            Element root = document.getDocumentElement();

            // Traverse the XML tree
            traverse(root, 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void traverse(Element root, int depth) {
        // Print the node name and its depth
        System.out.println(printIndentation(depth) + root.getNodeName());

        // Get the list of children
        List<Element> children = root.getChildNodes();

        // Traverse each child
        for (int i = 0; i < children.size(); i++) {
            Element child = (Element) children.get(i);
            traverse(child, depth + 1);
        }
    }

    private static String printIndentation(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}