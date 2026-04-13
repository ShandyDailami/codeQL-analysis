import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_24030_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("student");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                Element eElement = (Element) nNode;

                String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                String id = eElement.getElementsByTagName("id").item(0).getTextContent();
                String course = eElement.getElementsByTagName("course").item(0).getTextContent();

                System.out.println("Name: " + name);
                System.out.println("ID: " + id);
                System.out.println("Course: " + course);
            }

            System.out.println("XML Parsing Successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}