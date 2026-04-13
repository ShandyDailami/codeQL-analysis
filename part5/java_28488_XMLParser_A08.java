import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_28488_XMLParser_A08 {

    // Handler class to handle XML parsing
    private class MyHandler extends DefaultHandler {
        private boolean isA08_IntegrityFailure = false;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("A08_IntegrityFailure")) {
                isA08_IntegrityFailure = true;
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("A08_IntegrityFailure")) {
                isA08_IntegrityFailure = false;
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isA08_IntegrityFailure) {
                String integrityFailure = new String(ch, start, length);
                System.out.println("Security Violation Found: " + integrityFailure);
            }
        }
    }

    public void parse(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        parser.parse(new File(fileName), handler);
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parse("sample.xml"); // Replace with your file path
    }
}