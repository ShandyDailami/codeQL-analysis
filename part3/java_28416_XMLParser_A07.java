import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_28416_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Extract information from the XML file
            NodeList nList = doc.getElementsByTagName("student");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    // Get the information from each student
                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String id = eElement.getElementsByTagName("id").item(0).getTextContent();
                    String department = eElement.getElementsByTagName("department").item(0).getTextContent();

                    // Print the information
                    System.out.println("Name: " + name);
                    System.out.println("ID: " + id);
                    System.out.println("Department: " + department);
                }
            }

            // Add your security sensitive operations here

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}