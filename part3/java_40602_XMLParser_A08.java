import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.util.List;
import java.util.ArrayList;

public class java_40602_XMLParser_A08 {

    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        List<String> elements = parser.parse("example.xml");
        for (String element : elements) {
            System.out.println(element);
        }
    }

    public List<String> parse(String fileName) {
        List<String> elements = new ArrayList<>();
        try {
            File inputFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("*");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Element element = (Element) nodeList.item(temp);
                elements.add(element.getTagName());
            }
        } catch (Exception e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
        return elements;
    }
}