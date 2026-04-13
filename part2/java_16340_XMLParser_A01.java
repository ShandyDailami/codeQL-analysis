import java.io.File;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class java_16340_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

            printElement(doc.getDocumentElement(), 1);

            Iterator<Node> iterator = doc.getIteratory();
            while (iterator.hasNext()) {
                Node node = iterator.nextNode();
                if (node instanceof Element) {
                    printElement((Element) node, 1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void printElement(Element element, int indentation) {
        for (int i = 0; i < indentation; i++) {
            System.out.print("  ");
        }
        System.out.println("- " + element.getElementsByTagName("name").item(0).getTextContent());

        NodeList children = element.getElementsByTagName("child");
        for (int i = 0; i < children.getLength(); i++) {
            printElement((Element) children.item(i), indentation + 1);
        }
    }
}