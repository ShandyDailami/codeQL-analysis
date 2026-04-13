import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_17958_XMLParser_A08 {

    public static void main(String[] args) {
        String xml = "<doc>\n"
                + "<person id='1'>\n"
                + "<name>John</name>\n"
                + "<age>30</age>\n"
                + "</person>\n"
                + "<person id='2'>\n"
                + "<name>Jane</name>\n"
                + "<age>28</age>\n"
                + "</person>\n"
                + "</doc>";
        parse(xml);
    }

    public static void parse(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());
        parser.parse(new StringReader(xml));
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("name")) {
                bName = true;
            } else if (qName.equals("age")) {
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("name")) {
                bName = false;
            } else if (qName.equals("age")) {
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
            } else if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }
}