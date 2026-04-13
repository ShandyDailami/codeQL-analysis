import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_14647_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            File inputFile = new File("data.xml");

            saxParser.parse(inputFile, MyHandler.myHandler);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private static boolean bookTitle = false;
        private static boolean bookPrice = false;
        private static boolean bookAuthor = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bookTitle = true;
                bookPrice = false;
                bookAuthor = false;
            }
            if (qName.equalsIgnoreCase("title")) {
                bookTitle = true;
            }
            if (qName.equalsIgnoreCase("price")) {
                bookPrice = true;
            }
            if (qName.equalsIgnoreCase("author")) {
                bookAuthor = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bookTitle = false;
                bookPrice = false;
                bookAuthor = false;
            }
            if (qName.equalsIgnoreCase("title")) {
                bookTitle = false;
            }
            if (qName.equalsIgnoreCase("price")) {
                bookPrice = false;
            }
            if (qName.equalsIgnoreCase("author")) {
                bookAuthor = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bookTitle) {
                System.out.println("Book Title: " + new String(ch, start, length));
            }
            if (bookPrice) {
                System.out.println("Book Price: " + new String(ch, start, length));
            }
            if (bookAuthor) {
                System.out.println("Book Author: " + new String(ch, start, length));
            }
        }
    }
}