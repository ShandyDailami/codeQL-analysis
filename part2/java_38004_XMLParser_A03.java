import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_38004_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("src/books.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder currentElement;
        private StringBuilder currentAuthor;

        @Override
        public void startDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of document");
        }

        @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
            currentElement = new StringBuilder(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equals("title")) {
                System.out.println("Title: " + currentElement.toString());
            } else if (qName.equals("author")) {
                System.out.println("Author: " + currentAuthor.toString());
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            currentAuthor = new StringBuilder(new String(ch, start, length));
        }

    }
}