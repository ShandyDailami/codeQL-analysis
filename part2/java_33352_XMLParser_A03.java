import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_33352_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Get the nodes
            NodeList nList = doc.getElementsByTagName("employee");

            // Iterate through the nodes
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                // Extract the data
                Element eElement = (Element) nNode;
                String id = eElement.getAttribute("id");
                String name = eElement.getAttribute("name");
                String position = eElement.getAttribute("position");
                String salary = eElement.getAttribute("salary");

                System.out.println("id: " + id);
                System.out.println("name: " + name);
                System.out.println("position: " + position);
                System.out.println("salary: " + salary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}