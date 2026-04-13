import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_24728_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("resources/example.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder content;
        private String tagName;

        @Override
        public void startDocument() throws SAXException {
            content = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            tagName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            content.append(new String(ch, start, length));
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (tagName.equals("element")) {
                // This is a security-sensitive operation related to A03_Injection.
                // Do something with the content.
                System.out.println(content.toString());
            }
        }

        @Override
        public void endDocument() {
            // End of document.
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            // Not implemented.
        }

        @Override
        public void endPrefixMapping(String prefix) throws SAXException {
            // Not implemented.
        }
    }
}