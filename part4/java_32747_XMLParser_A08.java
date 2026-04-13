import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_32747_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("resources/books.xml"), myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean isBook = false;
        private boolean isTitle = false;
        private boolean isAuthor = false;
        private boolean isPrice = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("book")) {
                isBook = true;
            } else if (qName.equals("title")) {
                isTitle = true;
            } else if (qName.equals("author")) {
                isAuthor = true;
            } else if (qName.equals("price")) {
                isPrice = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("book")) {
                isBook = false;
            } else if (qName.equals("title")) {
                isTitle = false;
            } else if (qName.equals("author")) {
                isAuthor = false;
            } else if (qName.equals("price")) {
                isPrice = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isBook) {
                System.out.println("Book: " + new String(ch, start, length));
            } else if (isTitle) {
                System.out.print("Title: " + new String(ch, start, length));
            } else if (isAuthor) {
                System.out.println("Author: " + new String(ch, start, length));
            } else if (isPrice) {
                System.out.println("Price: " + new String(ch, start, length));
            }
        }
    }
}