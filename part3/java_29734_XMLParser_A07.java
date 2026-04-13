import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_29734_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);
            saxParser.parse(new File("path_to_your_file.xml"), new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean isAuthFailure = false;
        private boolean isAuthSuccess = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("AuthFailure")) {
                isAuthFailure = true;
            }
            if (qName.equalsIgnoreCase("AuthSuccess")) {
                isAuthSuccess = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("AuthFailure")) {
                isAuthFailure = false;
            }
            if (qName.equalsIgnoreCase("AuthSuccess")) {
                isAuthSuccess = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isAuthFailure) {
                System.out.println("AuthFailure: " + new String(ch, start, length));
            }
            if (isAuthSuccess) {
                System.out.println("AuthSuccess: " + new String(ch, start, length));
            }
        }
    }
}