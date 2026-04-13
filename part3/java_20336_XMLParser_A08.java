import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_20336_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            printElementsAndAttributes(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementsAndAttributes(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Element: " + eElement.getNodeName());
                System.out.println("Attributes:");
                for (int i = 0; i < eElement.getAttributeCount(); i++) {
                    System.out.println("   " + eElement.getAttributeNode(i).getNodeName() + "=" + eElement.getAttributeNode(i).getTextContent());
                }
            }
        }
    }
}