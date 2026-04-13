import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.xmlreader.XMLReader;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_23060_XMLParser_A01 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParser saxParser = new SAXParser();
        SAXHandler saxHandler = new SAXHandler();

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new InputSource(new FileInputStream(inputFile)));
            saxParser.setContentHandler(saxHandler);
            saxParser.parse(new InputSource(new FileInputStream(inputFile)));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {

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