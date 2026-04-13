import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.Iterator;

public class java_37368_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            printElement(doc, null);
        } catch (Exception e) {
            e.printStackTrace();
       
        }
    }

    private static void printElement(Document doc, Node node) {
        NodeList children = doc.getElementsByTagName("*");
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                if (node == null || child.getNodeName().equals(node.getNodeName())) {
                    System.out.println("Node Name: " + child.getNodeName());
                    System.out.println("Node Value: " + child.getNodeValue());
                    printElement(doc, child);
                }
            }
        }
    }
}