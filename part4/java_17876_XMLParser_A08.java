import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_17876_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("path/to/your/file.xml"), new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private static final String USERNAME_TAG = "username";
        private static final String PASSWORD_TAG = "password";

        private boolean bUsername = false;
        private boolean bPassword = false;

        private String currentUsername = null;
        private String currentPassword = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase(USERNAME_TAG)) {
                bUsername = true;
            } else if (qName.equalsIgnoreCase(PASSWORD_TAG)) {
                bPassword = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase(USERNAME_TAG)) {
                bUsername = false;
            } else if (qName.equalsIgnoreCase(PASSWORD_TAG)) {
                bPassword = false;
            }

            currentUsername = null;
            currentPassword = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bUsername) {
                currentUsername = new String(ch, start, length);
            } else if (bPassword) {
                currentPassword = new String(ch, start, length);
            }
        }

        @Override
        public void warning(SAXParseException e) {
            System.out.println("Warnings: " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) {
            System.out.println("Errors: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) {
            System.out.println("Fatal errors: " + e.getMessage());
        }
    }
}