import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_29611_XMLParser_A08 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            printNodes(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void printNodes(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Element: " + eElement.getTagName());
                System.out.println("Attributes: ");
                printAttributes(eElement);
            }
        }
    }

    static void printAttributes(Element eElement) {
        for (int temp = 0; temp < eElement.getAttributes().getLength(); temp++) {
            Node nNode = eElement.getAttributes().item(temp);
            System.out.println(" - " + nNode.getNodeName() + " = " + nNode.getTextContent());
        }
    }
}