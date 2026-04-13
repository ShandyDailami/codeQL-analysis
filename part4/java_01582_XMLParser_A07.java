import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_01582_XMLParser_A07 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("sample.xml")); // replace with your file path

            document.getDocumentElement().normalize();

            NodeList nodes = document.getElementsByTagName("student");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                Element element = (Element) node;

                String id = element.getAttribute("id");
                String name = element.getAttribute("name");
                String grade = element.getAttribute("grade");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Grade: " + grade);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}