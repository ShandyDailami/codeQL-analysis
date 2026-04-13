import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXSource;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_11759_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        parseXml(xmlFile);
    }

    private static void parseXml(File xmlFile) {
        SAXHandler handler = new SAXHandler();
        try {
            SAXSource source = new SAXSource(XMLReaderFactory.createXMLReader(), xmlFile);
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class SAXHandler extends DefaultHandler {

        private boolean isBook = false;
        private boolean isTitle = false;
        private boolean isAuthor = false;
        private boolean isPrice = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                isBook = true;
            } else if (qName.equalsIgnoreCase("title")) {
                isTitle = true;
            } else if (qName.equalsIgnoreCase("author")) {
                isAuthor = true;
            } else if (qName.equalsIgnoreCase("price")) {
                isPrice = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                isBook = false;
            } else if (qName.equalsIgnoreCase("title")) {
                isTitle = false;
            } else if (qName.equalsIgnoreCase("author")) {
                isAuthor = false;
            } else if (qName.equalsIgnoreCase("price")) {
                isPrice = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isBook) {
                System.out.println("Book: " + new String(ch, start, length));
            } else if (isTitle) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (isAuthor) {
                System.out.println("Author: " + new String(ch, start, length));
            } else if (isPrice) {
                System.out.println("Price: " + new String(ch, start, length));
            }
        }
    }
}