import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;
import java.io.IOException;

public class java_33539_XMLParser_A03 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("sample.xml"));

            doc.getDocumentElement().normalize();

            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            NodeList nodeList = doc.getElementsByTagName("student");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("Student " + (i + 1) + " :");
                Element element = (Element) node;

                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String id = element.getElementsByTagName("id").item(0).getTextContent();
                String age = element.getElementsByTagName("age").item(0).getTextContent();

                System.out.println("Name: " + name);
                System.out.println("ID: " + id);
                System.out.println("Age: " + age);
                System.out.println();
            }

            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}