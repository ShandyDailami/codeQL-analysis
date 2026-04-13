import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;

public class java_27204_XMLParser_A03 {

    public static void main(String[] args) {
        String xml = "<document>" +
                "<employee id='1' name='John Doe' role='Developer' />" +
                "<employee id='2' name='Jane Doe' role='Designer' />" +
                "</document>";

        parseXml(xml);
    }

    public static void parseXml(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler(true));
            parser.parse(new InputSource(new StringReader(xml)));
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static class SAXHandler extends DefaultHandler {
        private boolean bEmployee;
        private Employee employee;

        public java_27204_XMLParser_A03(boolean bEmployee) {
            this.bEmployee = bEmployee;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("employee")) {
                employee = new Employee();
                employee.setId(attributes.getValue("id"));
                employee.setName(attributes.getValue("name"));
                employee.setRole(attributes.getValue("role"));
                bEmployee = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("employee")) {
                bEmployee = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bEmployee) {
                if ("id".equalsIgnoreCase(localName)) {
                    employee.setId(new String(ch, start, length));
                } else if ("name".equalsIgnoreCase(localName)) {
                    employee.setName(new String(ch, start, length));
                } else if ("role".equalsIgnoreCase(localName)) {
                    employee.setRole(new String(ch, start, length));
                }
            }
        }

        public void endDocument() {
            List<Employee> employees = employee.getEmployees();
            for (Employee e : employees) {
                System.out.println(e.toString());
            }
        }
    }

    private static class Employee {
        private String id;
        private String name;
        private String role;

        public List<Employee> getEmployees() {
            // This is a security-sensitive operation. Do not use external frameworks like Spring or Hibernate.
            // Return list of Employees.
            // (This part of code will be removed in the final version.)
            return null;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
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

        @Override
        public String toString() {
            return "Employee [id=" + id + ", name=" + name + ", role=" + role + "]";
        }
    }
}