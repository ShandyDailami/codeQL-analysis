import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_26559_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("test.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try {
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("student");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    // Print data from each node
                    System.out.println("Student ID: " + eElement.getAttribute("id"));
                    System.out.println("Student Name: " + eElement.getAttribute("name"));
                    System.out.println("Student Age: " + eElement.getAttribute("age"));
                    System.out.println("Student Email: " + eElement.getAttribute("email"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}