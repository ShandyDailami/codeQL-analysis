import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_29268_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            printData(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printData(Document doc) {
        NodeList nList = doc.getElementsByTagName("entry");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\n  Entry - " + (temp + 1));
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("  ID: " + eElement.getAttribute("id"));
                System.out.println("  Name: " + eElement.getAttribute("name"));
                System.out.println("  Description: " + eElement.getAttribute("description"));
            }
        }
    }
}