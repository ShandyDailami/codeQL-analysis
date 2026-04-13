import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_21091_XMLParser_A07 {

    public static void main(String[] args) throws Exception {
        String xml = "<root><name>John</name><age>30</age></root>";

        // Use StringReader for in-memory xml
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MyHandler handler = new MyHandler();
        parser.parse(new StringReader(xml), handler);
    }

    static class MyHandler extends DefaultHandler {

        private StringBuilder data = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            data.setLength(0);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("name".equals(qName)) {
                System.out.println("Name: " + data.toString());
            } else if ("age".equals(qName)) {
                System.out.println("Age: " + data.toString());
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            data.append(ch, start, length);
        }
    }
}