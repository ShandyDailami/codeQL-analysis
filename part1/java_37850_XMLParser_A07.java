import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_37850_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler());

            parser.parse(new File("books.xml"), true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean isBook = false;
        private boolean isTitle = false;
        private boolean isAuthor = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                isBook = true;
                isTitle = false;
                isAuthor = false;
            } else if (qName.equalsIgnoreCase("title")) {
                isTitle = true;
            } else if (qName.equalsIgnoreCase("author")) {
                isAuthor = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                isBook = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isBook) {
                String content = new String(ch, start, length).trim();
                if (isTitle) {
                    System.out.println("Title: " + content);
                } else if (isAuthor) {
                    System.out.println("Author: " + content);
                }
            }
        }
    }
}