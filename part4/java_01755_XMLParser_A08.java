import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_01755_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("movies.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean movie = false;
        private boolean name = false;
        private boolean year = false;
        private boolean director = false;

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
            if (qName.equalsIgnoreCase("movie")) {
                movie = true;
            } else if (movie) {
                if (qName.equalsIgnoreCase("name")) {
                    name = true;
                } else if (qName.equalsIgnoreCase("year")) {
                    year = true;
                } else if (qName.equalsIgnoreCase("director")) {
                    director = true;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("movie")) {
                movie = false;
            } else if (qName.equalsIgnoreCase("name")) {
                name = false;
            } else if (qName.equalsIgnoreCase("year")) {
                year = false;
            } else if (qName.equalsIgnoreCase("director")) {
                director = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (name) {
                System.out.println("Name: " + new String(ch, start, length));
            } else if (year) {
                System.out.println("Year: " + new String(ch, start, length));
            } else if (director) {
                System.out.println("Director: " + new String(ch, start, length));
            }
        }
    }
}