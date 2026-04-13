import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;

public class java_09573_XMLParser_A01 {

    private DefaultHandler handler;

    public java_09573_XMLParser_A01(DefaultHandler handler) {
        this.handler = handler;
    }

    public void parse(String fileName) {
        try {
            XMLParser parser = new XMLLoader(new File(fileName));
            parser.setContentHandler(handler);
            parser.parse(new File(fileName));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class DefaultHandler extends org.xml.sax.helpers.DefaultHandler {

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Parsing document...");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document reached");
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
}