import java.io.File;
import java.util.Iterator;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_08173_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null);
            MyHandler handler = new MyHandler();
            saxParser.parse(new File("books.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean isTitle = false;
        boolean isYear = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("title")) {
                isTitle = true;
            } else if (qName.equals("year")) {
                isYear = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("title")) {
                isTitle = false;
            } else if (qName.equals("year")) {
                isYear = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isTitle) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (isYear) {
                System.out.println("Year: " + new String(ch, start, length));
            }
        }
    }
}