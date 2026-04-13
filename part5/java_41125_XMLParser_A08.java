import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_41125_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser(true);

        MyHandler myHandler = new MyHandler();
        saxParser.parse("src/main/resources/sample.xml", myHandler);
    }
}

class MyHandler extends DefaultHandler {
    boolean bName = false;
    boolean bAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("person")) {
            bName = true;
            bAge = true;
        }
        if (qName.equals("name")) {
            bName = true;
        }
        if (qName.equals("age")) {
            bAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person")) {
            bName = false;
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            // Process the name
            System.out.println("Name: " + new String(ch, start, length));
        }
        if (bAge) {
            // Process the age
            System.out.println("Age: " + new String(ch, start, length));
        }
    }
}