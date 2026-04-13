import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_17925_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File xmlFile = new File("example.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Extract data from XML
            NodeList nList = doc.getElementsByTagName("employee");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    // Print data
                    System.out.println("Employee ID: " + eElement.getAttribute("id"));
                    System.out.println("Employee Name: " + eElement.getAttribute("name"));
                    System.out.println("Employee Department: " + eElement.getAttribute("dept"));
                    System.out.println("Employee Position: " + eElement.getAttribute("position"));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}