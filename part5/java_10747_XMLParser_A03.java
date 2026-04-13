import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_10747_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            saxParser.parse(new File("books.xml"), handler);
        } catch (SAXException | IOException e) {
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
            if (qName.equalsIgnoreCase("book")) {
                book = true;
            } else if (qName.equalsIgnoreCase("title")) {
                title = true;
            } else if (qName.equalsIgnoreCase("author")) {
                author = true;
            } else if (qName.equalsIgnoreCase("price")) {
                price = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                book = false;
            } else if (qName.equalsIgnoreCase("title")) {
                title = false;
            } else if (qName.equalsIgnoreCase("author")) {
                author = false;
            } else if (qName.equalsIgnoreCase("price")) {
                price = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (book) {
                System.out.println("Book: " + new String(ch, start, length));
            } else if (title) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (author) {
                System.out.println("Author: " + new String(ch, start, length));
            } else if (price) {
                System.out.println("Price: " + new String(ch, start, length));
            }
        }
    }
}