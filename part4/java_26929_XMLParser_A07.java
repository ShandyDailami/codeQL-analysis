import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;

public class java_26929_XMLParser_A07 {
    public static void parseFile(String fileName) {
        XMLParser parser = new SAXParserImpl();
        DefaultHandler handler = new DefaultHandler() {
            boolean isAuthFailure = false;
            boolean isAuthFailureTag = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if ("AuthFailure".equals(localName)) {
                    isAuthFailure = true;
                    isAuthFailureTag = true;
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (isAuthFailureTag && isAuthFailure) {
                    System.out.println("Found an 'AuthFailure' element!");
                    isAuthFailure = false;
                    isAuthFailureTag = false;
                }
            }
        };

        try {
            XMLLoader loader = new XMLLoader(parser);
            loader.setContentHandler(handler);
            parser.parse(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class SAXParserImpl extends SAXParser {
        @Override
        public void startDocument() throws SAXException {
            // No implementation required
        }

        @Override
        public void endDocument() throws SAXException {
            // No implementation required
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // No implementation required
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // No implementation required
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // No implementation required
        }
    }
}