import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_26870_XMLParser_A07 {

    public static void main(String[] args) {

        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            printNodeNamesAndAttributes(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNodeNamesAndAttributes(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp != nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Element : " + eElement.getTagName());
                System.out.println("Attributes : ");
                printAttributes(eElement);
            }
        }
    }

    private static void printAttributes(Element eElement) {
        int nNumAttrs = eElement.getNumAttributes();
        for (int i = 0; i < nNumAttrs; i++) {
            System.out.println("Attribute : " + eElement.getAttributeNode(i).getNodeName() + " = " + eElement.getAttributeNode(i).getTextContent());
        }
    }
}