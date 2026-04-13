import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_06297_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("src/input.xml"), new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private StringBuilder currentValue;

        @Override
        public void startDocument() {
            System.out.println("Starting document...");
        }

        @Override
        public void endDocument() {
            System.out.println("Ending document...");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Starting element: " + qName);
            currentValue = new StringBuilder();
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("Ending element: " + qName);
            System.out.println("Value: " + currentValue.toString());
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            System.out.println("Characters: " + new String(ch, start, length));
            currentValue.append(new String(ch, start, length));
        }
    }
}