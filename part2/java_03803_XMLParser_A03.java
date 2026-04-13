import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class java_03803_XMLParser_A03 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("student");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Element element = (Element) nList.item(temp);
            String name = element.getElementsByTagName("name").item(0).getTextContent();
            String age = element.getElementsByTagName("age").item(0).getTextContent();
            String course = element.getElementsByTagName("course").item(0).getTextContent();
            System.out.println("Name : " + name);
            System.out.println("Age : " + age);
            System.out.println("Course : " + course);
            System.out.println("---");
        }
    }
}