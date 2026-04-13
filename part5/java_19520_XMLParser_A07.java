import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_19520_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParser saxParser = new SAXParser();
        try {
            saxParser.parse("src/main/resources/auth.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parse(String file) throws IOException {
        File xmlFile = new File(file);
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new ContentHandler());
        reader.parse(xmlFile);
    }

    private class SAXParser {
        private DefaultHandler handler;

        public java_19520_XMLParser_A07() {
            handler = new DefaultHandler();
        }

        public void parse(String file) throws IOException {
            SAXReader saxReader = new SAXReader();
            saxReader.setContentHandler(handler);
            saxReader.parse(new File(file));
        }
    }

    private class ContentHandler extends DefaultHandler {

        private boolean isAuthFailure = false;
        private boolean isAuthSuccess = false;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("authFailure")) {
                isAuthFailure = true;
            } else if (qName.equalsIgnoreCase("authSuccess")) {
                isAuthSuccess = true;
            }
        }

        @Override
        public java_19520_XMLParser_A07(String uri, String localName, String qName) throws SAXException {
            if (isAuthFailure) {
                System.out.println("AuthFailure found: " + qName);
                isAuthFailure = false;
            } else if (isAuthSuccess) {
                System.out.println("AuthSuccess found: " + qName);
                isAuthSuccess = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isAuthFailure || isAuthSuccess) {
                System.out.println("Character data: " + new String(ch, start, length));
            }
        }
    }
}