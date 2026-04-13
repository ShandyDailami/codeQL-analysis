import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_26245_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("src/main/resources/books.xml"), new MyHandler());
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean isBook = false;
        boolean isTitle = false;
        boolean isAuthor = false;
        boolean isPrice = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                isBook = true;
            } else if (qName.equalsIgnoreCase("title")) {
                isTitle = true;
            } else if (qName.equalsIgnoreCase("author")) {
                isAuthor = true;
            } else if (qName.equalsIgnoreCase("price")) {
                isPrice = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                isBook = false;
            } else if (qName.equalsIgnoreCase("title")) {
                isTitle = false;
            } else if (qName.equalsIgnoreCase("author")) {
                isAuthor = false;
            } else if (qName.equalsIgnoreCase("price")) {
                isPrice = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isBook) {
                System.out.println("Book: " + new String(ch, start, length));
            } else if (isTitle) {
                System.out.print("Title: " + new String(ch, start, length));
                isTitle = false;
            } else if (isAuthor) {
                System.out.println("Author: " + new String(ch, start, length));
                isAuthor = false;
            } else if (isPrice) {
                System.out.println("Price: " + new String(ch, start, length));
                isPrice = false;
            }
        }
    }
}