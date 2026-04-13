import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class java_17131_XMLParser_A07 {

    private static final String AUTH_FAILURE_ELEMENT = "A07_AuthFailure";

    private List<String> authFailures;

    public java_17131_XMLParser_A07(List<String> authFailures) {
        this.authFailures = authFailures;
    }

    public void parse(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new XMLHandler(authFailures));
            parser.parse(new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class XMLHandler extends DefaultHandler {
        private List<String> authFailures;
        private StringBuilder data;

        public java_17131_XMLParser_A07(List<String> authFailures) {
            this.authFailures = authFailures;
            this.data = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            data = new StringBuilder();
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (localName.equals(AUTH_FAILURE_ELEMENT)) {
                authFailures.add(data.toString());
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            data.append(new String(ch, start, length));
        }
    }
}