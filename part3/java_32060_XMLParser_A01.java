import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_32060_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("input.xml"), true);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean isPerson;
        private String currentElement;

        @Override
        public void startElement(String namespaceURI, String localName, String qName, Attributes attributes) throws SAXException {
            isPerson = localName.equals("person");
            currentElement = qName;
        }

        @Override
        public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
            if (isPerson) {
                System.out.println("End element: " + qName);
            }
            if (qName.equals("name")) {
                isPerson = false;
            }
            currentElement = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isPerson) {
                System.out.println("Character data: " + new String(ch, start, length));
            }
        }
    }
}