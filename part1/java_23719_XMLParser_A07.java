import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_23719_XMLParser_A07 {

    public static void parseFile(String filename) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new ParserHandler());
            parser.parse(new File(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class ParserHandler extends DefaultHandler {

        private boolean isAuthor;
        private boolean isTitle;
        private boolean isYear;

        @Override
        public void startDocument() {
            System.out.println("Parsing a document... ");
        }

        @Override
        public void endDocument() {
            System.out.println("Finished parsing the document.");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                isAuthor = true;
                isTitle = true;
                isYear = true;
            } else if (qName.equalsIgnoreCase("author")) {
                isAuthor = true;
            } else if (qName.equalsIgnoreCase("title")) {
                isTitle = true;
            } else if (qName.equalsIgnoreCase("year")) {
                isYear = true;
            } else if (qName.equalsIgnoreCase("publisher")) {
                // Ignoring publisher element
                isAuthor = false;
                isTitle = false;
                isYear = false;
            } else if (isAuthor) {
                System.out.println("Author: " + attributes.getValue("name"));
                isAuthor = false;
            } else if (isTitle) {
                System.out.println("Title: " + attributes.getValue("name"));
                isTitle = false;
            } else if (isYear) {
                System.out.println("Year: " + attributes.getValue("name"));
                isYear = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                isAuthor = false;
                isTitle = false;
                isYear = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isAuthor || isTitle || isYear) {
                System.out.println("Character data: " + new String(ch, start, length));
            }
        }
    }
}