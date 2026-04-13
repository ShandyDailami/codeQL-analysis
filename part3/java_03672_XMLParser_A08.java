import java.util.List;
import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_03672_XMLParser_A08 {

    public static void main(String[] args) {
        parseXML("employees.xml");
    }

    public static void parseXML(String fileName) {
        File xmlFile = new File(fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("employee");

        List<Employee> employeeList = new ArrayList<>();

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                Employee employee = new Employee();
                employee.setId(Integer.parseInt(eElement.getAttribute("id")));
                employee.setName(eElement.getAttribute("name"));
                employee.setDepartment(eElement.getAttribute("department"));
                employee.setRole(eElement.getAttribute("role"));
                employeeList.add(employee);
            }
        }

        for (Employee employee : employeeList) {
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Employee Name: " + employee.getName());
            System.out.println("Department: " + employee.getDepartment());
            System.out.println("Role: " + employee.getRole());
            System.out.println("-----------------");
        }
    }

    static class Employee {
        private int id;
        private String name;
        private String department;
        private String role;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}