import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_04379_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("employee");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("Employee " + (i + 1));
                System.out.println("Name: " + node.getElementsByTagName("name")
                        .item(0).getTextContent());
                System.out.println("Age: " + node.getElementsByTagName("age")
                        .item(0).getTextContent());
                System.out.println("Department: " + node.getElementsByTagName("department")
                        .item(0).getTextContent());
                System.out.println("Role: " + node.getElementsByTagName("role")
                        .item(0).getTextContent());
                System.out.println("---------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}