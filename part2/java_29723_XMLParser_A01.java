import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_29723_XMLParser_A01 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        parse(inputFile);
    }

    public static void parse(File inputFile) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try {
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            printNode(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printNode(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nNode Name : " + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Element : " + eElement.getTagName());
                System.out.println("Attributes : ");
                for (int j = 0; j < eElement.getAttributes().getLength(); j++) {
                    System.out.println(eElement.getAttributes().item(j).getNodeName() + " : " + eElement.getAttributes().item(j).getTextContent());
                }
            }
        }
    }
}