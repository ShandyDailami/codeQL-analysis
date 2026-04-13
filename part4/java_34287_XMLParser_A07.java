import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_34287_XMLParser_A07 {

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());
        parser.parse(new File("authFailure.xml"), false); // parse file into DOM
    }

    static class MyHandler extends DefaultHandler {
        private boolean isAuthFailure = false;
        private boolean isFailed = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("authFailure")) {
                isAuthFailure = true;
            }

            if (qName.equalsIgnoreCase("failed")) {
                isFailed = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("authFailure")) {
                isAuthFailure = false;
            }

            if (qName.equalsIgnoreCase("failed")) {
                isFailed = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isAuthFailure && isFailed) {
                System.out.println("Authentication failure detected!");
            }
        }
    }
}