import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_31197_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Creating a DocumentBuilderFactory instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Creating a DocumentBuilder instance
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsing the document
            Document doc = builder.parse(new File("sample.xml"));

            // Getting the root element of the document
            Element root = doc.getDocumentElement();

            // Getting the list of elements with the tag name "employee"
            NodeList nodes = root.getElementsByTagName("employee");

            // Iterating through each employee element
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                Element employee = (Element) node;

                // Extracting and printing the employee name
                String name = employee.getElementsByTagName("name").item(0).getTextContent();
                String id = employee.getElementsByTagName("id").item(0).getTextContent();
                String salary = employee.getElementsByTagName("salary").item(0).getTextContent();

                System.out.println("Employee ID: " + id + ", Name: " + name + ", Salary: " + salary);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}