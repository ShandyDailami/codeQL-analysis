import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_06779_XMLParser_A03 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new SAXContentHandler());
            saxParser.parse(inputFile, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXContentHandler extends DefaultHandler {
        private boolean isName = false;
        private boolean isValue = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("name")) {
                isName = true;
            } else if (qName.equals("value")) {
                isValue = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isName) {
                // Security-sensitive operation: Do not print sensitive information
                System.out.println("Name: " + new String(ch, start, length));
                isName = false;
            } else if (isValue) {
                // Security-sensitive operation: Do not print sensitive information
                System.out.println("Value: " + new String(ch, start, length));
                isValue = false;
            }
        }
    }
}