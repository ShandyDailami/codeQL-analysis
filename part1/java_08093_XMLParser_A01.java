import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_08093_XMLParser_A01 {
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

    public static void printData(Document doc) {
        NodeList nList = doc.getElementsByTagName("employee");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Employee ID: " + eElement.getAttribute("id"));
                System.out.println("Employee Name: " + eElement.getElementsByTagName("name")
                        .item(0).getTextContent());
                System.out.println("Employee Role: " + eElement.getElementsByTagName("role")
                        .item(0).getTextContent());
            }
        }
    }
}