import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_11761_XMLParser_A08 extends DefaultHandler {
    private String currElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        currElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currElement.equalsIgnoreCase("employee")) {
            // Do not print any information if the root element is not "employee"
            return;
        }
        if (currElement.equalsIgnoreCase("name")) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (currElement.equalsIgnoreCase("age")) {
            System.out.println("Age: " + new String(ch, start, length));
        } else if (currElement.equalsIgnoreCase("salary")) {
            System.out.println("Salary: " + new String(ch, start, length));
        }
    }
}

public class XMLParserExample {
    public static void main(String[] args) {
        String xml = "<employees>\n" +
                "  <employee>\n" +
                "    <name>John</name>\n" +
                "    <age>30</age>\n" +
                "    <salary>5000</salary>\n" +
                "  </employee>\n" +
                "  <employee>\n" +
                "    <name>Jane</name>\n" +
                "    <age>28</age>\n" +
                "    <salary>6000</salary>\n" +
                "  </employee>\n" +
                "</employees>";

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            EmployeeSAXHandler handler = new EmployeeSAXHandler();
            parser.parse(new StringReader(xml), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}