import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_29566_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");  // replace with your xml file path
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
            printElement(doc.getDocumentElement(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void printElement(Node node, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            System.out.print(element.getNodeName());
            if (element.getAttributes().getLength() > 0) {
                System.out.print(" (");
                for (int i = 0; i < element.getAttributes().getLength(); i++) {
                    if (i > 0) {
                        System.out.print(", ");
                    }
                    System.out.print(element.getAttributes().item(i).getNodeName() + "='"
                            + element.getAttributes().item(i).getNodeValue() + "'");
                }
                System.out.print(")");
            }
            System.out.println();
        }
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printElement(children.item(i), indent + 4);
        }
    }
}