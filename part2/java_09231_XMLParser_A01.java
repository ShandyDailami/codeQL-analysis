import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_09231_XMLParser_A01 {
    private DefaultHandler defaultHandler;

    public java_09231_XMLParser_A01(DefaultHandler defaultHandler) {
        this.defaultHandler = defaultHandler;
    }

    public void parse(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, defaultHandler);
            saxParser.parse(new File(fileName), defaultHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class DefaultHandlerImpl extends DefaultHandler {
        private boolean isElement = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            isElement = true;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            isElement = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isElement) {
                // Do something with the characters here
            }
        }
    }
}