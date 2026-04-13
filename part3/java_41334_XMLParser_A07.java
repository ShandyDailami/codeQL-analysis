import java.security.Access;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_41334_XMLParser_A07 {

    // SAX handler
    private class SecurityHandler extends DefaultHandler {
        private boolean isAuthFailure = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (localName.equals("authFailure")) {
                isAuthFailure = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (localName.equals("authFailure")) {
                isAuthFailure = false;
            }
        }

        public boolean isAuthFailure() {
            return isAuthFailure;
        }
    }

    public static void main(String[] args) throws Exception {
        // Set up SAX parser
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null);

        // Set up security handler
        SecurityHandler handler = new SecurityHandler();
        parser.setContentHandler(handler);

        // Parse XML
        Source source = new StreamSource(new StringReader("<root><authFailure/></root>"));
        parser.parse(source, null);

        if (handler.isAuthFailure()) {
            System.out.println("Access attempt detected in secure area!");
        } else {
            System.out.println("Access attempt detected in non-secure area!");
        }
    }
}