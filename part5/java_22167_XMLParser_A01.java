import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_22167_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Step 1: Load the XML document
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Step 2: Extract and print the information about the employees
            NodeList nList = doc.getElementsByTagName("employee");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element element = (Element) nList.item(temp);
                String empId = element.getElementsByTagName("id").item(0).getTextContent();
                String empName = element.getElementsByTagName("name").item(0).getTextContent();
                String empDept = element.getElementsByTagName("department").item(0).getTextContent();
                String empSalary = element.getElementsByTagName("salary").item(0).getTextContent();

                System.out.println("Employee Id: " + empId);
                System.out.println("Employee Name: " + empName);
                System.out.println("Employee Department: " + empDept);
                System.out.println("Employee Salary: " + empSalary);
            }

            // Step 3: Generate a new XML file with security-sensitive information
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("secure_input.xml"));
            transformer.transform(source, result);

            System.out.println("\nInformation in the new XML file is security-sensitive!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}