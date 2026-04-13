import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_04540_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("student");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String id = eElement.getAttribute("id");
                    String name = eElement.getAttribute("name");
                    String age = eElement.getAttribute("age");
                    System.out.println("Student id: " + id);
                    System.out.println("Student name: " + name);
                    System.out.println("Student age: " + age);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}