import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_39757_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path/to/your/xml/file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("element");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element eElement = (Element) nList.item(temp);
                System.out.println("Element name: " + eElement.getTagName());
                System.out.println("Element attribute: " + eElement.getAttribute("attribute"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}