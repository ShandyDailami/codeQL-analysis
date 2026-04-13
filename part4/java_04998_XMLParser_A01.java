import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_04998_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Step 1: Load the XML file
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Step 2: Extract the root element
            doc.getDocumentElement().normalize();

            // Step 3: Extract all the 'student' elements
            NodeList studentNodes = doc.getElementsByTagName("student");

            // Step 4: Process each 'student' element
            for (int i = 0; i < studentNodes.getLength(); i++) {
                Element studentElement = (Element) studentNodes.item(i);

                // Step 4.1: Extract the 'name' and 'age' attributes
                String name = studentElement.getAttribute("name");
                String age = studentElement.getAttribute("age");

                // Step 4.2: Process the 'name' and 'age' attributes
                System.out.println("Student name: " + name);
                System.out.println("Student age: " + age);
            }

            // Step 5: Close the XML file
            doc.getDocumentElement().normalize();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}