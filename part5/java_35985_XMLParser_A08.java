import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_35985_XMLParser_A08 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("legacy.xml"));
            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("student");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                Element element = (Element) node;

                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String id = element.getElementsByTagName("id").item(0).getTextContent();
                String course = element.getElementsByTagName("course").item(0).getTextContent();

                System.out.println("Name: " + name);
                System.out.println("ID: " + id);
                System.out.println("Course: " + course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}