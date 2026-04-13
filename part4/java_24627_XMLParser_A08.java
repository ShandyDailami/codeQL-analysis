import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_24627_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("resources/test.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Start of person : Name= " + attributes.getValue("name"));
            bName = true;
            bAge = true;
        } else if (bName) {
            System.out.println("End of person : Name= " + attributes.getValue("name"));
            bName = false;
        } else if (qName.equalsIgnoreCase("age")) {
            System.out.println("Start of age : Age= " + attributes.getValue("age"));
            bAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("End of person");
            bName = false;
        } else if (qName.equalsIgnoreCase("age")) {
            System.out.println("End of age");
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName || bAge) {
            System.out.println("Character data = " + new String(ch, start, length));
            bName = false;
            bAge = false;
        }
    }
}