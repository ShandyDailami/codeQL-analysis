import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_13997_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "books.xml";
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File(xmlFile), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean author;
        private boolean title;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("author")) {
                author = true;
            }

            if (qName.equalsIgnoreCase("title")) {
                title = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("author")) {
                author = false;
            }

            if (qName.equalsIgnoreCase("title")) {
                title = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (author) {
                System.out.println("Author: " + new String(ch, start, length));
            }

            if (title) {
                System.out.println("Title: " + new String(ch, start, length));
            }
        }
    }
}