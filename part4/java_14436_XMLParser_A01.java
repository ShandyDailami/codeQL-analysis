import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_14436_XMLParser_A01 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(new File("example.xml"));
            document.normalize();

            List<String> employeeList = parseEmployees(document);
            for (String emp : employeeList) {
                System.out.println(emp);
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> parseEmployees(Document document) {
        List<String> employeeList = new ArrayList<>();

        NodeList nodeList = document.getElementsByTagName("employee");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);

            String empName = element.getElementsByTagName("name").item(0).getTextContent();
            String empId = element.getElementsByTagName("id").item(0).getTextContent();

            employeeList.add("Employee Name: " + empName + ", Employee ID: " + empId);
        }

        return employeeList;
    }
}