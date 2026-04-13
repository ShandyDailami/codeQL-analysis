import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_05586_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("your_xml_file.xml");

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(new DTDHandler());
            saxParser.parse(xmlFile, new DTDHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class DTDHandler extends DefaultHandler {
        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("Start Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        @Override
        public void error(SAXParseException e) {
            System.out.println("SAXParseException: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) {
            System.out.println("Fatal SAXParseException: " + e.getMessage());
        }

        @Override
        public void warning(SAXParseException e) {
            System.out.println("SAXParseException: " + e.getMessage());
        }
    }
}