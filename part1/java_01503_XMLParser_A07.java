import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_01503_XMLParser_A07 {
    public static void main(String[] args) throws Exception {
        // Create a SAXParser factory
        SAXParserFactory spf = SAXParserFactory.newInstance();

        // Create a SAXParser
        SAXParser sp = spf.newSAXParser(new DefaultHandler());

        // Parse the XML document
        sp.parse(new File("src/main/resources/example.xml"), new MyHandler());
    }

    static class MyHandler extends DefaultHandler {
        private boolean isName = false;
        private boolean isAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                isName = true;
            } else if (qName.equalsIgnoreCase("age")) {
                isAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                isName = false;
            } else if (qName.equalsIgnoreCase("age")) {
                isAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isName) {
                System.out.println("Name: " + new String(ch, start, length));
            } else if (isAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }
}