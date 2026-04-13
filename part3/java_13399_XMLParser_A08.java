import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.List;
import java.util.ArrayList;

public class java_13399_XMLParser_A08 {

    public List<String> parse(String filename) {
        List<String> result = new ArrayList<>();
        File inputFile = new File(filename);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("student");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                String age = eElement.getElementsByTagName("age").item(0).getTextContent();
                result.add(name + " " + age);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        List<String> students = parser.parse("students.xml");
        for (String student : students) {
            System.out.println(student);
        }
    }
}