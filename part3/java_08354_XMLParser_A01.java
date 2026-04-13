import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_08354_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("sample.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;
        String qName = null;
        String name = null;
        String age = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            qName = localName;
            if ("person".equals(qName)) {
                bName = true;
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            qName = localName;
            if ("person".equals(qName)) {
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                name = new String(ch, start, length);
                bName = false;
            } else if (bAge) {
                age = new String(ch, start, length);
                bAge = false;
            }
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            // ignored
        }

        @Override
        public void endPrefixMapping(String prefix) throws SAXException {
            // ignored
        }
    }
}