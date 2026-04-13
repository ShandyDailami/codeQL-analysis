import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_20474_XMLParser_A08 extends DefaultHandler {

    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equalsIgnoreCase("employee")) {
            System.out.println("Employee ID: " + new String(ch, start, length));
        } else if (currentElement.equalsIgnoreCase("name")) {
            System.out.println("Employee Name: " + new String(ch, start, length));
        } else if (currentElement.equalsIgnoreCase("salary")) {
            System.out.println("Employee Salary: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        MyXMLParser myHandler = new MyXMLParser();
        saxParser.parse("src/employees.xml", myHandler);
    }
}