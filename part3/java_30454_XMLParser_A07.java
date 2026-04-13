import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_30454_XMLParser_A07 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            bName = true;
            bAge = true;
        }
        if (bName && qName.equalsIgnoreCase("name")) {
            // do something
        } else if (bAge && qName.equalsIgnoreCase("age")) {
            // do something
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            bName = false;
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            // do something with the name
        } else if (bAge) {
            // do something with the age
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser();
        MyHandler myHandler = new MyHandler();
        saxParser.parse(new File("students.xml"), myHandler);
    }
}