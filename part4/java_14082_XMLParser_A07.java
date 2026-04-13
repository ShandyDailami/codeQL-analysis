import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLStreamReader;

import java.io.File;
import java.io.IOException;

public class java_14082_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            MyHandler handler = new MyHandler();
            saxParser.parse(new File("authfailure.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Handle start element here
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Handle end element here
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Handle characters here
        }
    }
}