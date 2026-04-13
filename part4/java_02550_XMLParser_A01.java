import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_02550_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(XmlParser.class.getResourceAsStream("broken.xml"), new SAXHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuffer buffer = new StringBuffer();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            buffer.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            buffer.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // Here we're assuming that we want to find a specific tag and print its content
            if ("element".equals(qName)) {
                System.out.println("Content: " + buffer.toString());
            }
        }
    }

    static class SAXHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            // Do not do anything here. SAX does not allow to read files while it is parsing
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            // Do not do anything here. SAX does not allow to read files while it is parsing
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Do not do anything here. SAX does not allow to read files while it is parsing
        }
    }
}