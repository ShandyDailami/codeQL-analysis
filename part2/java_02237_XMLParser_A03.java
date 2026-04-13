import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_02237_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserExample saxParserExample = new SAXParserExample();
        saxParserExample.parseXML("legacy.xml");
    }

    private void parseXML(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(Class.forName("org.xml.sax.SAXParser"));

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File(fileName), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class MyHandler extends DefaultHandler {

        private boolean isElement = false;
        private String currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            isElement = true;
            currentElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            isElement = false;
            currentElement = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isElement) {
                // Implement your security sensitive operations here.
                String elementContent = new String(ch, start, length);
                System.out.println("Element: " + currentElement + ", Content: " + elementContent);
            }
        }
    }
}