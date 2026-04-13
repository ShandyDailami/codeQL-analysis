import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_20847_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            // Parse the input file
            Document doc = dBuilder.parse(new File("input.xml"));
            // Get the root element
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            // Extract and print the employee details
            printEmployee(doc);
            // Close the document
            doc.getDocumentElement().normalize();
            System.out.println("\nEmployee Details : ");
            // Print employee data
            printEmployee(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printEmployee(Document doc) {
        NodeList nList = doc.getElementsByTagName("employee");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nEmployee Node : " + temp + " " + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                // Print employee ID
                System.out.println("ID : " + eElement.getAttribute("id"));
                // Print employee name
                System.out.println("Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                // Print employee department
                System.out.println("Department : " + eElement.getElementsByTagName("department").item(0).getTextContent());
            }
        }
    }
}