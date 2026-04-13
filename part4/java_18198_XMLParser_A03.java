import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_18198_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("src/main/resources/employees.xml"), true);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean isEmployee = false;
    private boolean isName = false;
    private boolean isAge = false;
    private StringBuilder employeeData = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("Employee")) {
            isEmployee = true;
            employeeData.setLength(0);
        }

        if (isEmployee) {
            if (qName.equalsIgnoreCase("Name")) {
                isName = true;
            } else if (qName.equalsIgnoreCase("Age")) {
                isAge = true;
            } else {
                isEmployee = false;
            }
        }

        if (isEmployee && isName) {
            employeeData.append(attributes.getValue("Name"));
        } else if (isEmployee && isAge) {
            employeeData.append(attributes.getValue("Age"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Employee")) {
            System.out.println(employeeData);
            isEmployee = false;
        }
    }
}