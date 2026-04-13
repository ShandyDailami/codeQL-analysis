import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_07952_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();

            saxParser.parse(xmlFile, myHandler);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            // Handle start element here
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Handle end element here
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Handle characters here
        }
    }
}