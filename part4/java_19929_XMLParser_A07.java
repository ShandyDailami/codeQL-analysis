import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_19929_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Load the XML file
            File xmlFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Extract and print all the nodes
            printNodes(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNodes(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Tag name: " + element.getTagName());
                System.out.println("Attribute value: " + element.getAttribute("attr"));
                System.out.println("Node value: " + element.getTextContent());
            }
        }
    }
}