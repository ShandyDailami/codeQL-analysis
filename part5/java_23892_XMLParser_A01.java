import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_23892_XMLParser_A01 {
    private static final String XML_FILE = "src/test.xml";

    public static void main(String[] args) {
        File xmlFile = new File(XML_FILE);

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(xmlFile.toURI());

        MyHandler handler = new MyHandler();
        saxParser.parse(xmlFile, handler);
    }

    private static class MyHandler extends DefaultHandler {
        private boolean nameFound = false;
        private boolean idFound = false;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);

            if (qName.equalsIgnoreCase("name")) {
                nameFound = true;
            } else if (qName.equalsIgnoreCase("id")) {
                idFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);

            if (qName.equalsIgnoreCase("name")) {
                nameFound = false;
            } else if (qName.equalsIgnoreCase("id")) {
                idFound = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (nameFound) {
                System.out.println("Name: " + new String(ch, start, length));
            } else if (idFound) {
                System.out.println("ID: " + new String(ch, start, length));
            }
        }
    }
}