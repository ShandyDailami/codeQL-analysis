import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_34254_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler());
            parser.parse(new File("input.xml"), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {
        private boolean isName;
        private boolean isPassword;

        @Override
        public void startDocument() throws SAXException {
            isName = false;
            isPassword = false;
        }

        @Override
        public void endDocument() throws SAXException {
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                isName = true;
            } else if (qName.equalsIgnoreCase("password")) {
                isPassword = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (isName) {
                System.out.println("Name: " + qName);
                isName = false;
            } else if (isPassword) {
                System.out.println("Password: " + qName);
                isPassword = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isName || isPassword) {
                System.out.print(new String(ch, start, length));
            }
        }
    }
}