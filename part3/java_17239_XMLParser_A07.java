import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.Iterator;
import java.util.LinkedList;

public class java_17239_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getElementsByTagName("root").item(0).getTextContent());
            
            printNodes(doc.getElementsByTagName("node"));

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
            System.out.println("Tag name: " + element.getTagName());
            System.out.println("Attribute: " + element.getAttribute("attr"));
            printNodes(element.getElementsByTagName("node"));
        }
    }
}