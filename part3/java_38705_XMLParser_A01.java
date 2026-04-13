import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_38705_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // load the xml file
            Document doc = builder.parse(new File("sample.xml"));

            // select all elements with 'employee' tag
            NodeList nodes = doc.getElementsByTagName("employee");

            // print all 'employee' tags
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                Element element = (Element) node;

                // print employee id
                System.out.println("Employee ID: " + element.getAttribute("id"));

                // print employee name
                System.out.println("Employee Name: " + element.getElementsByTagName("name").item(0).getTextContent());

                // print employee department
                System.out.println("Employee Department: " + element.getElementsByTagName("department").item(0).getTextContent());
                System.out.println("----------------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}