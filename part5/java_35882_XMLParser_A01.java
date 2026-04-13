import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_35882_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            
            // Create a DocumentBuilder using the factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Read the XML file into a Document object
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Get all employee nodes
            NodeList nList = doc.getElementsByTagName("employee");

            // Traverse through each employee node
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                // Extract and print the employee detail
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    // Extract and print the employee detail
                    System.out.println("Employee ID: " + eElement.getAttribute("id"));
                    System.out.println("Employee Name: " + eElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Employee Role: " + eElement.getElementsByTagName("role").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}