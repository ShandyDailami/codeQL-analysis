import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_32960_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Get the element with the tag name "employee"
            NodeList employees = document.getElementsByTagName("employee");
            for (int i = 0; i < employees.getLength(); i++) {
                Element employeeElement = (Element) employees.item(i);

                // Get the attribute value
                String name = employeeElement.getAttribute("name");
                String id = employeeElement.getAttribute("id");
                String title = employeeElement.getAttribute("title");

                System.out.println("Employee ID: " + id);
                System.out.println("Employee Name: " + name);
                System.out.println("Employee Title: " + title);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}