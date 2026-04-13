import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_24798_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a new instance of DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a new instance of DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document document = builder.parse(new SourceResource("input.xml"));

            // Get the root element of the document
            Element root = document.getDocumentElement();

            // Print the name and age of all employees
            printEmployees(root);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printEmployees(Element root) {
        NodeList employees = root.getElementsByTagName("employee");

        for (int i = 0; i < employees.getLength(); i++) {
            Element employee = (Element) employees.item(i);

            String name = employee.getElementsByTagName("name").item(0).getTextContent();
            String age = employee.getElementsByTagName("age").item(0).getTextContent();

            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }
    }
}