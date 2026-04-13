import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;

public class java_18934_XMLParser_A01 {
    private static class SAXHandler extends DefaultHandler {
        public void startDocument() {
            System.out.println("Start document");
        }

        public void endDocument() {
            System.out.println("End document");
        }

        public void parse(String fileName) {
            try {
                SAXParserFactory spf = SAXParserFactory.newInstance();
                SAXParser sp = spf.newSAXParser(new org.xml.sax.InputSource(new File(fileName)));
                sp.parse(new File(fileName), new SAXHandler());
            } catch (Exception e) {
                System.out.println("Parsing failed: " + e.getMessage());
            }
        }

        public void startElement(String uri, String localName, String qName) {
            System.out.println("Start element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) {
            System.out.println("End element: " + qName);
        }

        public void characters(char[] ch, int start, int length) {
            String value = new String(ch, start, length);
            System.out.println("Character data: " + value);
        }
    }

    public static void main(String[] args) {
        SAXHandler handler = new SAXHandler();
        handler.parse("input.xml");
    }
}