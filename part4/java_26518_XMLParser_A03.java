import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_26518_XMLParser_A03 {

    public static void main(String[] args) {

        try {
            // Step 1: Parse the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src/employees.xml"); // replace with your xml file

            // Step 2: Extract the employee nodes
            doc.getDocumentElement().normalize();
            NodeList employees = doc.getElementsByTagName("employee");

            // Step 3: Extract each employee node and extract the name and age
            for (int i = 0; i < employees.getLength(); i++) {
                Element employeeElement = (Element) employees.item(i);
                String name = employeeElement.getElementsByTagName("name").item(0).getTextContent();
                String age = employeeElement.getElementsByTagName("age").item(0).getTextContent();

                System.out.println("Name: " + name + ", Age: " + age);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}