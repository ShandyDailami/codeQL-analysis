import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class java_02976_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory and use it to create a DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Step 2: Parse the XML file
            Document doc = dBuilder.parse(new File("example.xml"));

            // Step 3: Retrieve the root element of the Document
            doc.getDocumentElement().normalize();

            // Step 4: Retrieve the list of the children of the root element
            NodeList nodeList = doc.getElementsByTagName("student");

            // Step 5: Process the list of nodes
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Element node = (Element) nodeList.item(temp);

                // Step 6: Extract the data from the XML node
                String id = node.getAttribute("id");
                String name = node.getAttribute("name");
                String grade = node.getAttribute("grade");

                // Step 7: Print the data
                System.out.println("Student ID: " + id);
                System.out.println("Student Name: " + name);
                System.out.println("Student Grade: " + grade);
            }

            // Step 8: Close the Document
            doc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}