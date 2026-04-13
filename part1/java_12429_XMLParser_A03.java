import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_12429_XMLParser_A03 extends DefaultHandler {

    private final String filePath;

    public java_12429_XMLParser_A03(String filePath) {
        this.filePath = filePath;
    }

    public void parse() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new SecurityHandler(filePath));
            parser.parse(new File(filePath));
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    static class SecurityHandler extends DefaultHandler {

        private final String filePath;

        public java_12429_XMLParser_A03(String filePath) {
            this.filePath = filePath;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Do not execute any code that could potentially be used for injection.
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Do not execute any code that could potentially be used for injection.
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Do not execute any code that could potentially be used for injection.
        }
    }
}