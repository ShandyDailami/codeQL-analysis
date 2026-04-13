import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_23104_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
            printElement(doc, doc.getDocumentElement());
        } catch (Exception e) {
            e.printStackTrace();
       
        }
    }

    private static void printElement(Document doc, Element node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("Child Node : " + childNode.getNodeName());
                printElement((Document) childNode, (Element) childNode);
            } else if (childNode.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text Node : " + childNode.getNodeValue());
            }
        }
    }
}