import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParserFactory;

public class java_34461_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser(true);

            XMLHandler handler = new XMLHandler();
            saxParser.parse(new InputStreamReader(new FileInputStream("legacy.xml"), "UTF-8"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class XMLHandler extends DefaultHandler {
        private boolean isAuthor = false;
        private boolean isBook = false;
        private boolean isTitle = false;
        private boolean isYear = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("Author")) {
                isAuthor = true;
            } else if (qName.equalsIgnoreCase("Book")) {
                isBook = true;
            } else if (qName.equalsIgnoreCase("Title")) {
                isTitle = true;
            } else if (qName.equalsIgnoreCase("Year")) {
                isYear = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("Author")) {
                isAuthor = false;
            } else if (qName.equalsIgnoreCase("Book")) {
                isBook = false;
            } else if (qName.equalsIgnoreCase("Title")) {
                isTitle = false;
            } else if (qName.equalsIgnoreCase("Year")) {
                isYear = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isAuthor) {
                System.out.println("Author: " + new String(ch, start, length));
            } else if (isBook) {
                System.out.println("Book: " + new String(ch, start, length));
            } else if (isTitle) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (isYear) {
                System.out.println("Year: " + new String(ch, start, length));
            }
        }
    }
}