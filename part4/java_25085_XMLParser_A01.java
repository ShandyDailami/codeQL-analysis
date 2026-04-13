import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_25085_XMLParser_A01 extends DefaultHandler {

    private boolean isName = false;
    private boolean isValue = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("name")) {
            isName = true;
        } else if (qName.equals("value")) {
            isValue = true;
        } else {
            System.out.println("Start element: " + qName);
            System.out.println("Attributes: " + attributes);
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("name")) {
            isName = false;
        } else if (qName.equals("value")) {
            isValue = false;
        } else {
            System.out.println("End element: " + qName);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            System.out.println("Reading name: " + new String(ch, start, length));
        } else if (isValue) {
            System.out.println("Reading value: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SecuritySensitiveXMLParser handler = new SecuritySensitiveXMLParser();
            saxParser.parse(new java.io.File("sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}