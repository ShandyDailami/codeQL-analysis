import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_05119_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true); // Use true to get fully functional parser

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("sample.xml"), myHandler);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    // DefaultHandler
    private static class MyHandler extends DefaultHandler {

        private boolean accessControl = false;
        private boolean brokenAccessControl = false;

        @Override
        public void startDocument() throws SAXException {
            accessControl = true;
        }

        @Override
        public void endDocument() throws SAXException {
            if (brokenAccessControl) {
                System.out.println("Broken access control found, skipping...");
            } else {
                System.out.println("Access control not found.");
            }
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("brokenAccessControl")) {
                brokenAccessControl = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("brokenAccessControl")) {
                brokenAccessControl = false;
            }
        }
    }
}