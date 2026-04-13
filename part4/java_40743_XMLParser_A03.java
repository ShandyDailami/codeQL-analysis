import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_40743_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load XML Document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("sample.xml"));
            doc.getDocumentElement().normalize();

            // Print all element nodes
            NodeList nList = doc.getElementsByTagName("employee");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);
                Element eElement = (Element) node;

                // Print node's information
                System.out.println("Employee Name: " + eElement.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Employee ID: " + eElement.getElementsByTagName("id").item(0).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}