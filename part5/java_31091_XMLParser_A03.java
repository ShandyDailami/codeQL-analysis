import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_31091_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml");  // replace with your xml file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            printElement(doc, doc.getDocumentElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Document doc, Element element) {
        System.out.println("Element: " + element.getNodeName());
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                printElement((Document) node, (Element) node);
            } else if (node.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text: " + node.getNodeValue());
            }
        }
    }
}