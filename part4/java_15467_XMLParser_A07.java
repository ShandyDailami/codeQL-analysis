import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLResourceLoader;

import java.io.File;
import java.io.IOException;

public class java_15467_XMLParser_A07 {

    public static void main(String[] args) {
        String url = "http://www.w3schools.com/xml/books.xml";
        try {
            XMLParserExample handler = new XMLParserExample();
            XMLResourceLoader loader = new XMLResourceLoader();
            XMLParser parser = loader.parse(url, handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class MyHandler extends DefaultHandler {

        private boolean author;
        private boolean price;

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
            if (qName.equalsIgnoreCase("book")) {
                author = true;
                price = true;
            }
            if (qName.equalsIgnoreCase("author")) {
                author = true;
            }
            if (qName.equalsIgnoreCase("price")) {
                price = true;
            }
        }

        @Override
        public java_15467_XMLParser_A07(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                author = false;
                price = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (author) {
                System.out.println("Author: " + new String(ch, start, length));
                author = false;
            }
            if (price) {
                System.out.println("Price: " + new String(ch, start, length));
                price = false;
            }
        }
    }
}