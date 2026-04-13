import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_17573_XMLParser_A03 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("input.xml"));

            doc.getDocumentElement().normalize();

            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

            printElement(doc.getDocumentElement(), 1);

            List<Map<String, String>> attributes = doc.getElementsByTagName("*");
            for (int i = 0; i < attributes.size(); i++) {
                Map<String, String> attribute = attributes.get(i);
                System.out.println("Attribute : " + attribute);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element element, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println("Element: " + element.getNodeName() + " : " + element.getTextContent());

        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                printElement((Element) child, level + 1);
            }
        }
    }
}