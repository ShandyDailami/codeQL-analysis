import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_27550_XMLParser_A08 extends DefaultHandler {
    boolean bName = false;
    boolean bSalary = false;
    String name = null;
    float salary = 0;

    public void startDocument() {
        System.out.println("Start of document.");
    }

    public void endDocument() {
        System.out.println("End of document.");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("employee")) {
            System.out.println("Employee name: " + name);
            System.out.println("Employee salary: " + salary);
            System.out.println("--------------------");
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("employee")) {
            System.out.println("--------------------");
        }
    }

    public void characters(char[] ch, int start, int length) {
        if (bName) {
            name = new String(ch, start, length);
            bName = false;
        } else if (bSalary) {
            salary = Float.parseFloat(new String(ch, start, length));
            bSalary = false;
        }
    }

    public static void main(String[] args) {
        File inputFile = new File("employees.xml");
        EmployeeHandler handler = new EmployeeHandler();

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new HandlerAdapter(handler));
            parser.parse(inputFile, handler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}