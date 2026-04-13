import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_25204_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Get the DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Get all the elements
            NodeList nList = doc.getElementsByTagName("student");

            // Iterate over each element
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                // If the element is an element, print the element's details
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    // Get the student details
                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String id = eElement.getElementsByTagName("id").item(0).getTextContent();
                    String age = eElement.getElementsByTagName("age").item(0).getTextContent();

                    // Print the details
                    System.out.println("Name: " + name);
                    System.out.println("ID: " + id);
                    System.out.println("Age: " + age);
                    System.out.println("");
                }
            }

            // Close the Document
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}