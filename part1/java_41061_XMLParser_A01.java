import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class java_41061_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Use it to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use the builder to parse the XML file
            Document doc = builder.parse(new File("employees.xml"));

            // Get the root element of the document
            doc.getDocumentElement().normalize();

            // Find all the 'employee' elements
            NodeList employees = doc.getElementsByTagName("employee");

            // Extract and print all 'name' elements
            for (int i = 0; i < employees.getLength(); i++) {
                Element employee = (Element) employees.item(i);
                System.out.println("Name: " + employee.getElementsByTagName("name").item(0).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}