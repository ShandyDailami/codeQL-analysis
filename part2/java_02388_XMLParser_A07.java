import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_02388_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("src/main/resources/authFailure.xml"), new SAXSettings());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean isAuthFailure = false;
        private StringBuilder data;

        @Override
        public void startDocument() throws SAXException {
            isAuthFailure = true;
            data = new StringBuilder();
        }

        @Override
        public void endDocument() throws SAXException {
            isAuthFailure = false;
        }

        @Override
        public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
            data.setLength(0);
            if (isAuthFailure && qualifiedName.equals("AuthFailure")) {
                isAuthFailure = false;
                String authFailureData = data.toString();
                // Security-sensitive operations related to AuthFailure
                System.out.println(authFailureData);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            data.append(new String(ch, start, length));
        }
    }

    static class SAXSettings implements SAXSettings {
        @Override
        public boolean getFeature(String name) {
            return false;
        }

        @Override
        public void setFeature(String name, boolean b) {
        }

        @Override
        public void startDocument() throws SAXException {
        }

        @Override
        public void endDocument() throws SAXException {
        }

        @Override
        public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
        }

        @Override
        public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
        }
    }
}