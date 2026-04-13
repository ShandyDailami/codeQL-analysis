import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_28365_XMLParser_A08 extends DefaultHandler {
    boolean bName = false;
    boolean bAge = false;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        }
        if (bName && qName.equalsIgnoreCase("name")) {
            System.out.println("Name: ");
            bName = false;
        }
        if (bAge && qName.equalsIgnoreCase("age")) {
            System.out.println("Age: ");
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = false;
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println(new String(ch, start, length));
        }
        if (bAge) {
            System.out.println(new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser();

        MyXMLParser myHandler = new MyXMLParser();
        saxParser.parse(args[0], myHandler);
    }
}