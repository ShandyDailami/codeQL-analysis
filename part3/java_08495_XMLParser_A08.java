import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.List;
import java.util.LinkedList;

public class java_08495_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            printElements(document.getElementsByTagName("*"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(NodeList nodeList) {
        List<String> elements = new LinkedList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                elements.add(node.getNodeName());
                printElements(node.getChildNodes());
            }
        }
        for (String element : elements) {
            System.out.println(element);
        }
    }
}