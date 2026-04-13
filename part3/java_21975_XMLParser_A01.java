import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_21975_XMLParser_A01 extends DefaultHandler {

    private boolean bName = false;
    private boolean bSalary = false;
    private String currentElement = "";
    private Employee employee;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        currentElement = qName;

        if (qName.equalsIgnoreCase("employee")) {
            employee = new Employee();
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("salary")) {
            bSalary = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        currentElement = "";

        if (qName.equalsIgnoreCase("employee")) {
            System.out.println(employee.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bName) {
            employee.setName(new String(ch, start, length));
            bName = false;
        } else if (bSalary) {
            employee.setSalary(Double.parseDouble(new String(ch, start, length)));
            bSalary = false;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(new File("employees.xml"), new EmployeeSaxHandler());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}