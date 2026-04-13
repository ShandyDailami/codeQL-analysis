import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_33116_XMLParser_A03 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("yourfile.xml")); // replace "yourfile.xml" with your xml file

            // get the document element
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            // print all element nodes
            printNodes(doc.getElementsByTagName("*"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNodes(NodeList nodes) {
        for (int i = 0; i < nodes.getLength(); i++) {
            printNode(nodes.item(i));
        }
    }

    private static void printNode(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            System.out.println("Element: " + element.getNodeName());
            printNodes(element.getElementsByTagName("*"));
        } else if (node.getNodeType() == Node.TEXT_NODE) {
            System.out.println("Text Node: " + node.getNodeValue());
        }
    }
}