import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_27317_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml"); // provide the path to your xml file

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("student");

            for (int temp = 0; temp != nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("Student Name : " + eElement.getAttribute("name"));
                    System.out.println("Student ID : " + eElement.getAttribute("id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}