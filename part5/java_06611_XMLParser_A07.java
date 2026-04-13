import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_06611_XMLParser_A07 extends DefaultHandler {

    private boolean bName;
    private boolean bAge;
    private boolean bDepartment;

    private String employeeName;
    private int employeeAge;
    private String employeeDepartment;

    public java_06611_XMLParser_A07() {
        bName = bAge = bDepartment = true;
    }

    public void parse(String file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new Handler());
            parser.parse(new File(file), null);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("employee")) {
            employeeName = "";
            employeeAge = 0;
            employeeDepartment = "";
        } else if (qName.equalsIgnoreCase("name")) {
            bName = false;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = false;
        } else if (qName.equalsIgnoreCase("department")) {
            bDepartment = false;
        }
    }

    public void characters(char[] ch, int start, int length) {
        if (bName) {
            employeeName = new String(ch, start, length);
        } else if (bAge) {
            employeeAge = Integer.parseInt(new String(ch, start, length));
        } else if (bDepartment) {
            employeeDepartment = new String(ch, start, length);
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("employee")) {
            System.out.println("Employee Name: " + employeeName);
            System.out.println("Employee Age: " + employeeAge);
            System.out.println("Employee Department: " + employeeDepartment);
        }
    }

    public static void main(String[] args) {
        new XMLParser().parse("src/main/resources/employees.xml");
    }
}