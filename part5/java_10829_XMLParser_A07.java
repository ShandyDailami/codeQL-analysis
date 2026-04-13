import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;

public class java_10829_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new InputSource(new File("sample.xml")));
            saxParser.setContentHandler(new SAXContentHandlerImpl());
            saxParser.parse(new File("sample.xml"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static class SAXContentHandlerImpl extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Implement your SAX logic here
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Implement your SAX logic here
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Implement your SAX logic here
        }

        @Override
        public void startDocument(String uri, String localName, String version) throws SAXException {
            // Implement your SAX logic here
        }

        @Override
        public void endDocument(String uri, String localName, String version) throws SAXException {
            // Implement your SAX logic here
        }

    }
}