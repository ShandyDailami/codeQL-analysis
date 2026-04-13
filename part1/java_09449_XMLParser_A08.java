import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.logging.Logger;

public class java_09449_XMLParser_A08 {
    private static final Logger LOGGER = Logger.getLogger(XMLParser.class.getName());

    public static void main(String[] args) {
        // Create a new instance of DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load the XML document
        Document doc = builder.parse(new File("employees.xml"));

        // Get all the employees
        NodeList employees = doc.getElementsByTagName("employee");

        // Iterate over all employees
        for (int i = 0; i < employees.getLength(); i++) {
            Node employeeNode = employees.item(i);

            // Extract the employee details
            Element employeeElement = employeeNode.getChildNodes().item(0).getAsElement();
            String name = employeeElement.getAttribute("name");
            String position = employeeElement.getAttribute("position");
            String salary = employeeElement.getAttribute("salary");

            // Print the employee details
            LOGGER.info(String.format("Employee %s works as a %s for $%s", name, position, salary));
       
        }
    }
}