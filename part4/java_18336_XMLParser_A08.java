import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_18336_XMLParser_A08 extends DefaultHandler {
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals("name")) {
            System.out.println(new String(ch, start, length));
        }
    }
}

public class XmlParser {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        EmployeeHandler handler = new EmployeeHandler();
        parser.parse(XmlParser.class.getResourceAsStream("employees.xml"), handler);
    }
}