import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_36586_XMLParser_A08 {
    private DefaultHandler handler;

    public java_36586_XMLParser_A08() {
        handler = new DefaultHandler();
    }

    public void parse(String filePath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new Handler());
            parser.parse(new File(filePath), handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private class Handler extends DefaultHandler {
        private boolean isElement;
        private String currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            isElement = true;
            currentElement = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isElement) {
                String value = new String(ch, start, length);
                System.out.println(currentElement + ": " + value);
                isElement = false;
            }
        }
    }
}