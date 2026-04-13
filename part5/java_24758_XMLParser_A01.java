import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.xml.parsers.DocumentBuilder;
import org.apache.xml.parsers.DocumentBuilderFactory;
import org.apache.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_24758_XMLParser_A01 {

    public List<Employee> parseEmployees(String fileName) {
        List<Employee> employees = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(new File(fileName));
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fis);
            doc.getDocumentElement().normalize();

            NodeList employeesList = doc.getElementsByTagName("employee");
            for (int i = 0; i < employeesList.getLength(); i++) {
                Element employeeElement = (Element) employeesList.item(i);
                Employee employee = new Employee();
                employee.setId(Integer.parseInt(employeeElement.getAttribute("id")));
                employee.setName(employeeElement.getAttribute("name"));
                employee.setRole(employeeElement.getAttribute("role"));
                employees.add(employee);
            }
            fis.close();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public class Employee {
        private int id;
        private String name;
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

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}