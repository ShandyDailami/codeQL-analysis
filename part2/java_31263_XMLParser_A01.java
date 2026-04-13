import java.io.File;
import java.util.List;
import java.util.ArrayList;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;

public class java_31263_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            parse("employees.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parse(String file) throws Exception {
        File xmlFile = new File(file);
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        DefaultHandler defaultHandler = new DefaultHandler();

        XMLReader xmlReader = XMLReaderFactory.createXMLReader(new EmployeeHandler(defaultHandler));
        xmlReader.setFeature("http://xml.org/sax/features/namespaces", true);
        xmlReader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);

        xmlReader.parse(xmlFile);
    }

    static class EmployeeHandler extends DefaultHandler {
        private List<Employee> employees = new ArrayList<>();
        private Employee current;

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
            switch (qName) {
                case "employee":
                    current = new Employee();
                    current.setId(attributes.getValue("id"));
                    break;
                case "name":
                    current.setName(attributes.getValue(""));
                    break;
                case "salary":
                    current.setSalary(Double.parseDouble(attributes.getValue("")));
                    break;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            switch (qName) {
                case "employee":
                    employees.add(current);
                    break;
            }
        }
    }

    static class Employee {
        private String id;
        private String name;
        private double salary;

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

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }
    }
}