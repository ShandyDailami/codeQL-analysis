import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_21074_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("books.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean book = false;
        boolean title = false;
        boolean author = false;
        boolean price = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("book")) {
                book = true;
            }

            if (book) {
                if (qName.equals("title")) {
                    title = true;
                } else if (qName.equals("author")) {
                    author = true;
                } else if (qName.equals("price")) {
                    price = true;
                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (book) {
                if (title) {
                    System.out.println("Title: " + new String(ch, start, length));
                } else if (author) {
                    System.out.println("Author: " + new String(ch, start, length));
                } else if (price) {
                    System.out.println("Price: " + new String(ch, start, length));
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("book")) {
                book = false;
            }
        }
    }
}