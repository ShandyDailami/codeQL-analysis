import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.util.List;

public class java_11774_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("employees.xml");
        parseEmployees(xmlFile);
    }

    public static void parseEmployees(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);

        document.getDocumentElement().normalize();
        NodeList employeeList = document.getElementsByTagName("employee");

        List<String> names = new ArrayList<>();
        for (int i = 0; i < employeeList.getLength(); i++) {
            Node employeeNode = employeeList.item(i);
            if (employeeNode.getNodeType() == Node.ELEMENT_NODE) {
                Element employeeElement = (Element) employeeNode;
                String name = employeeElement.getAttribute("name");
                names.add(name);
            }
        }

        System.out.println("Employee names: " + names);
    }
}