import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_25765_XMLParser_A01 {
    public static void main(String[] args) {
        String fileName = "test.xml";

        // Parse the XML file with SAX
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();

            // Create a custom handler to handle XML elements
            MyHandler handler = new MyHandler();
            saxParser.parse(new File(fileName), handler);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    // Create a custom SAX handler to handle XML elements
    private static class MyHandler extends DefaultHandler {
        private boolean isTitle = false;
        private boolean isLink = false;
        private String currentLink = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("title")) {
                isTitle = true;
            } else if (qName.equals("link")) {
                isLink = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("title")) {
                isTitle = false;
            } else if (qName.equals("link")) {
                isLink = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isTitle) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (isLink) {
                currentLink = new String(ch, start, length);
                System.out.println("Link: " + currentLink);
                isLink = false;
            }
        }
    }
}