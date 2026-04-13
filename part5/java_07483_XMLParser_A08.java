import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_07483_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml");  // replace with your xml file path
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("student");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Student Name: " + eElement.getAttribute("name"));
                    System.out.println("Student ID: " + eElement.getAttribute("id"));
                }
            }
            dBuilder = null;
            dbFactory = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}