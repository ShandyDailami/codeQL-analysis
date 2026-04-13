import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_02798_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            printElement(doc, doc.getDocumentElement());

            System.out.println("Document Loaded successfully.");
        } catch (Exception e) {
            e.printStackTrace();
       
        }
    }

    private static void printElement(Document doc, Element elem) {
        System.out.println("Element: " + elem.getNodeName());
        NodeList childNodes = elem.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                printElement((Document) node, (Element) node);
            } else if (node.getNodeType() == Node.TEXT_NODE) {
                System.out.print(node.getNodeValue() + " ");
            }
        }
    }
}