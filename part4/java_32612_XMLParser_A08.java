import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_32612_XMLParser_A08 {
    private DefaultHandler handler;

    public java_32612_XMLParser_A08() {
        handler = new DefaultHandler();
    }

    public void parse(String filename) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new Handler());
            parser.parse(new File(filename), handler);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    private class Handler extends DefaultHandler {
        private boolean inName = false;
        private boolean inValue = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("name")) {
                inName = true;
            } else if (qName.equals("value")) {
                inValue = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("name")) {
                inName = false;
            } else if (qName.equals("value")) {
                inValue = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (inName) {
                // handle name
            } else if (inValue) {
                // handle value, this is where you would add your security-sensitive operations related to integrity failures
            }
        }
    }
}