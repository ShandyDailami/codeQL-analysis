import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_38815_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(new File("input.xml"), handler);
        } catch (SAXParseException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            // start of the element
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // end of the element
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            // characters from the element
            String strChars = new String(ch, start, length);
            System.out.println("Characters: " + strChars);
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) {
            // start of a prefix mapping
            System.out.println("Start prefix mapping: " + prefix);
        }

        @Override
        public void endPrefixMapping(String prefix) {
            // end of a prefix mapping
            System.out.println("End prefix mapping: " + prefix);
        }
    }
}