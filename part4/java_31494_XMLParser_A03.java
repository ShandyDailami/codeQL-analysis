import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_31494_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            printNode(doc, doc.getDocumentElement());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void printNode(Document doc, Element node) {
        NodeList children = doc.getElementsByTagName(node.getTagName());
        for (int i = 0; i < children.getLength(); i++) {
            Node childNode = children.item(i);
            System.out.println("\nNode Name: " + childNode.getNodeName());
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                printNode((Document) childNode, (Element) childNode);
            } else if (childNode.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Node Value: " + childNode.getNodeValue());
            }
        }
    }
}