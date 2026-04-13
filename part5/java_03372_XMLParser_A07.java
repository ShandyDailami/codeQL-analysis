import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_03372_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse("src/input.xml", myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SAX Handler
    static class MyHandler extends DefaultHandler {

        boolean bTitle = false;
        boolean bLink = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            if (qName.equalsIgnoreCase("title")) {
                bTitle = true;
            } else if (qName.equalsIgnoreCase("link")) {
                bLink = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

            if (qName.equalsIgnoreCase("title")) {
                bTitle = false;
            } else if (qName.equalsIgnoreCase("link")) {
                bLink = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTitle) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (bLink) {
                System.out.println("Link: " + new String(ch, start, length));
            }
        }
    }
}