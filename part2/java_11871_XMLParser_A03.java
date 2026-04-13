import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_11871_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(new File("src/main/resources/employees.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bName = false;
    boolean bSalary = false;
    String empName = "";
    String empSalary = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("employee")) {
            bName = true;
            bSalary = false;
            empName = "";
            empSalary = "";
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("salary")) {
            bSalary = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("employee")) {
            bName = false;
            bSalary = false;
        } else if (qName.equalsIgnoreCase("name")) {
            empName = localName;
        } else if (qName.equalsIgnoreCase("salary")) {
            empSalary = localName;
        }

        if (bName) {
            System.out.println("Name: " + empName);
            System.out.println("Salary: " + empSalary);
            System.out.println("---");
            bName = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            empName = new String(ch, start, length);
        } else if (bSalary) {
            empSalary = new String(ch, start, length);
        }
    }
}