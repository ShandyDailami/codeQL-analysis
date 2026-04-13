import java.io.File;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLEventHandler;
import org.xml.sax.parser.XMLEventLocator;
import org.xml.sax.parser.XMLErrorHandler;

public class java_08964_XMLParser_A08 {

    public static void main(String[] args) {
        XMLReader reader = XMLParserFactory.createXMLReader();
        XMLEventHandler handler = new SAXHandler();
        reader.setContentHandler(handler);
        try {
            reader.parse(new File("input.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {

        @Override
        public void startDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String content = new String(ch, start, length);
            System.out.println("Content of element: " + content);
        }

        @Override
        public void warning(SAXParseException e) {
            System.out.println("SAX warning: " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) {
            System.out.println("SAX error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) {
            System.out.println("Fatal SAX error: " + e.getMessage());
        }
    }
}