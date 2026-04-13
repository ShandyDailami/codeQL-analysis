import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_11975_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            document.getDocumentElement().normalize();
            printNodeInfo(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNodeInfo(Document document) {
        NodeList nodes = document.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            printNodeInfo(nodes.item(i));
        }
    }

    private static void printNodeInfo(Node node) {
        if (node.hasChildNodes()) {
            System.out.println("Element: " + node.getNodeName());
            printNodeInfo(node.getFirstChild());
        } else if (node.getNodeType() == Node.TEXT_NODE) {
            System.out.println("Text: " + node.getNodeValue());
        }
    }
}