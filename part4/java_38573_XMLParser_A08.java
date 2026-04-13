import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.SAXException;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;

public class java_38573_XMLParser_A08 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private String tempValue;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("person")) {
            bName = true;
            bAge = true;
        } else if (bName && qName.equals("name")) {
            bName = false;
        } else if (bName && qName.equals("age")) {
            bAge = false;
        } else if (bAge && qName.equals("age")) {
            bAge = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            tempValue = new String(ch, start, length);
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person")) {
            System.out.println("Name: " + tempValue + ", Age: " + tempValue);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new File("sample.xml"), new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}