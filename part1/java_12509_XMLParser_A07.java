import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_12509_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        AuthFailureHandler authFailureHandler = new AuthFailureHandler();
        saxParser.parse(new File("src/main/resources/data.xml"), authFailureHandler);
    }

    static class AuthFailureHandler extends DefaultHandler {
        private boolean isAuthFailure = false;
        private StringBuilder authFailureData = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("AuthFailure")) {
                isAuthFailure = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isAuthFailure) {
                authFailureData.append(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("AuthFailure")) {
                // Handle the auth failure data here
                System.out.println("AuthFailure: " + authFailureData.toString());
                authFailureData.setLength(0); // Reset for the next auth failure
                isAuthFailure = false;
            }
        }
    }
}