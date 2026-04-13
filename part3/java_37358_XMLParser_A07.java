import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_37358_XMLParser_A07 {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new AuthFailureHandler());
        parser.parse(new File("src/main/resources/authFailure.xml"), new org.xml.sax.helpers.DefaultHandler() {
        });
    }

    static class AuthFailureHandler extends DefaultHandler {
        private boolean bAuthFailure = false;
        private boolean bFailedAuth = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("AuthFailure".equals(qName)) {
                bAuthFailure = true;
            }
            if ("FailedAuth".equals(qName)) {
                bFailedAuth = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("AuthFailure".equals(qName)) {
                bAuthFailure = false;
            }
            if ("FailedAuth".equals(qName)) {
                bFailedAuth = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bAuthFailure && bFailedAuth) {
                System.out.println("AuthFailure found!");
            }
        }
    }
}