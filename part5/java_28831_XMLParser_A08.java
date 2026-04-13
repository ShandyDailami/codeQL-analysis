import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;
import org.xml.sax.parser.XMLEventHandler;

import java.io.File;
import java.io.IOException;

public class java_28831_XMLParser_A08 {

    public static void parse(String filePath) {
        XMLParser parser = new SAXParserImpl();
        try {
            parser.parse(filePath, new DefaultHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class SAXParserImpl extends SAXParser {

        public java_28831_XMLParser_A08() throws SAXException {
            super(new DefaultHandler(), new XMLErrorHandler() {
                @Override
                public void warning(SAXParseException e) {
                    System.out.println("Warning: " + e.getMessage());
                }

                @Override
                public void error(SAXParseException e) {
                    System.out.println("Error: " + e.getMessage());
                }

                @Override
                public void fatalError(SAXParseException e) {
                    System.out.println("Fatal Error: " + e.getMessage());
                }
            });
        }

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    private static class DefaultHandler extends DefaultHandler {

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        parse("resources/example.xml");
    }
}