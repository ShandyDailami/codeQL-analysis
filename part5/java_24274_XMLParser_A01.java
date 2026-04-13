import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_24274_XMLParser_A01 {

    public static void main(String[] args) {
        parse("src/main/resources/sample.xml");
    }

    public static void parse(String xmlFile) {
        try {
            File inputFile = new File(xmlFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            printElements(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc) {
        NodeList nList = doc.getElementsByTagName("element");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            printElement(nNode);
        }
    }

    private static void printElement(Node nNode) {
        if (nNode instanceof Element) {
            Element eElement = (Element) nNode;
            System.out.println("element name: " + eElement.getNodeName() + ", attribute: " + eElement.getAttribute("attribute"));
        }
    }
}