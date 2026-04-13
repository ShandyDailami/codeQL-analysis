import java.io.File;
import java.security.AccessController;
import java.security.Access;
import java.util.Iterator;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_38822_XMLParser_A07 {

    public static void main(String[] args) {

        // Load XML File
        File xmlFile = new File("resources/test.xml");

        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser saxParser = spf.newSAXParser(null);

        // Handling XML file
        MyHandler myHandler = new MyHandler();
        saxParser.parse(xmlFile, myHandler);
    }

    static class MyHandler extends DefaultHandler {

        boolean bEmpName = false;
        boolean bDepName = false;
        boolean bSalary = false;

        String empName = null;
        String deptName = null;
        String salary = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {

            if (qName.equalsIgnoreCase("Employee")) {
                bEmpName = true;
            } else if (qName.equalsIgnoreCase("Department")) {
                bDepName = true;
            } else if (qName.equalsIgnoreCase("Salary")) {
                bSalary = true;
            }

        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

            if (qName.equalsIgnoreCase("Employee")) {
                bEmpName = false;
            } else if (qName.equalsIgnoreCase("Department")) {
                bDepName = false;
            } else if (qName.equalsIgnoreCase("Salary")) {
                bSalary = false;
            }

            if (bEmpName) {
                empName = "";
            } else if (bDepName) {
                deptName = "";
            } else if (bSalary) {
                salary = "";
            }

        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {

            if (bEmpName) {
                empName = new String(ch, start, length);
            } else if (bDepName) {
                deptName = new String(ch, start, length);
            } else if (bSalary) {
                salary = new String(ch, start, length);
            }

        }

        @Override
        public void endDocument() {
            System.out.println("Employee Name: " + empName);
            System.out.println("Department Name: " + deptName);
            System.out.println("Salary: " + salary);
        }
    }

}