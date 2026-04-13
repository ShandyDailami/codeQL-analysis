import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XSLTProcessor;
import org.xml.sax.xmlreader.SAXReader;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_25639_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(new File("input.xml"));

            // Remove the following lines to use SAX Reader
            // SAXReader reader = new SAXReader();
            // parser.parse("input.xml", new MyHandler());

            // SAX Reader
            // SAXReader reader = new SAXReader();
            // reader.parse("input.xml", new MyHandler());

            // SAX Parser
            // SAXParser parser = new SAXParser();
            // parser.parse("input.xml", new MyHandler());

            // SAX Handler
            // DefaultHandler handler = new MyHandler();
            // SAXParser parser = new SAXParser();
            // parser.parse("input.xml", handler);

            // SAX XSLT
            // XSLTProcessor processor = new XSLTProcessor();
            // processor.parse("input.xml", "input.xsl", "UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SAX Handler
    static class MyHandler extends DefaultHandler {

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
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Character data: " + new String(ch, start, length));
        }
    }
}