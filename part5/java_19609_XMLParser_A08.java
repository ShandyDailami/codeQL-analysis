import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_19609_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("student");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                Element element = (Element) node;

                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String id = element.getElementsByTagName("id").item(0).getTextContent();
                String course = element.getElementsByTagName("course").item(0).getTextContent();

                System.out.println("Name: " + name);
                System.out.println("ID: " + id);
                System.out.println("Course: " + course);
            }

            System.out.println("XML Parsing Complete!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}