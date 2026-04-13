import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_13252_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(XmlParser.class.getResourceAsStream("/data.xml"), myHandler);
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName;
    private boolean bAge;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = false;
            bAge = false;
        }
        if (qName.equalsIgnoreCase("name")) {
            bName = true;
        }
        if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        if (bName) {
            // Implement your security-sensitive operation here related to A08_IntegrityFailure
            String name = new String(chars, start, length);
            // Do something with name
        }
        if (bAge) {
            // Implement your security-sensitive operation here related to A08_IntegrityFailure
            int age = Integer.parseInt(new String(chars, start, length));
            // Do something with age
        }
    }
}