import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_41238_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("sample.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("student");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("Student - " + ((Element) nNode).getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Age - " + ((Element) nNode).getElementsByTagName("age").item(0).getTextContent());
                System.out.println("Course - " + ((Element) nNode).getElementsByTagName("course").item(0).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}