import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_07667_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();

            saxParser.parse(new File("books.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean isBook;
        private boolean isTitle;
        private boolean isAuthor;
        private boolean isYear;

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
            isBook = (qName.equals("book"));
            isTitle = (qName.equals("title"));
            isAuthor = (qName.equals("author"));
            isYear = (qName.equals("year"));
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (isBook) {
                System.out.println("Book: " + qName);
                isBook = false;
            } else if (isTitle) {
                System.out.println("Title: " + qName);
                isTitle = false;
            } else if (isAuthor) {
                System.out.println("Author: " + qName);
                isAuthor = false;
            } else if (isYear) {
                System.out.println("Year: " + qName);
                isYear = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isBook) {
                System.out.println("Book contains: " + new String(ch, start, length));
            }
        }
    }
}