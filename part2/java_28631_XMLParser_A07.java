import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_28631_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(new File("books.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bBook = false;
        boolean bTitle = false;
        boolean bAuthor = false;
        boolean bPrice = false;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bBook = true;
            } else if (qName.equalsIgnoreCase("title")) {
                bTitle = true;
            } else if (qName.equalsIgnoreCase("author")) {
                bAuthor = true;
            } else if (qName.equalsIgnoreCase("price")) {
                bPrice = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bBook = false;
            } else if (qName.equalsIgnoreCase("title")) {
                bTitle = false;
            } else if (qName.equalsIgnoreCase("author")) {
                bAuthor = false;
            } else if (qName.equalsIgnoreCase("price")) {
                bPrice = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bBook) {
                System.out.println("Book: " + new String(ch, start, length));
            } else if (bTitle) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (bAuthor) {
                System.out.println("Author: " + new String(ch, start, length));
            } else if (bPrice) {
                System.out.println("Price: " + new String(ch, start, length));
            }
        }
    }
}