import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_06831_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            printElementsAndAttributes(doc, doc.getDocumentElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementsAndAttributes(Document doc, Element root) {
        NodeList nodeList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node node = nodeList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                printElementAndAttributes(element, 1);
            }
        }
    }

    private static void printElementAndAttributes(Element element, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        System.out.print(element.getNodeName());
        if (element.hasAttributes()) {
            System.out.print(" (");
            for (int i = 0; i < element.getAttributes().getLength(); i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(element.getAttributes().item(i).getNodeName());
            }
            System.out.println(")");
        } else {
            System.out.println("");
        }
        System.out.println("");
    }
}