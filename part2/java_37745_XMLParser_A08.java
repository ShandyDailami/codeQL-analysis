import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class java_37745_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Security-sensitive operations related to A08_IntegrityFailure
            // ...

            NodeList nodeList = doc.getElementsByTagName("student");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Element node = (Element) nodeList.item(temp);

                // Retrieve and display information
                String name = node.getElementsByTagName("name").item(0).getTextContent();
                String id = node.getElementsByTagName("id").item(0).getTextContent();
                String department = node.getElementsByTagName("department").item(0).getTextContent();

                // Display information
                System.out.println("Name: " + name);
                System.out.println("ID: " + id);
                System.out.println("Department: " + department);
            }

            // More security-sensitive operations
            // ...

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}