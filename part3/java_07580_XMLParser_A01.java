import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLEventReader;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLEventHandler;

import java.io.File;
import java.io.IOException;

public class java_07580_XMLParser_A01 {

    private static class MyHandler extends DefaultHandler {

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
            System.out.println("Characters: " + new String(ch, start, length));
        }

        @Override
        public void fatalError(SAXException e) throws SAXException {
            System.out.println("Fatal error: " + e.getMessage());
        }

        @Override
        public void warning(SAXException e) throws SAXException {
            System.out.println("Warning: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            XMLReader parser = XMLParser.getSAXParser();
            XMLEventHandler handler = new MyHandler();
            XMLEventReader reader = parser.getSAXEventReader(handler);
            reader.parse(new File("example.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}