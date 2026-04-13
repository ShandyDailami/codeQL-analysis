import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLScanner;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

public class java_23510_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        SAXParserHandler handler = new SAXParserHandler();

        try {
            SAXReader reader = new SAXReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXParserHandler extends DefaultHandler {
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
    }
}