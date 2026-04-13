import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_15351_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("example.xml"), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean isElement = false;
        private boolean isAttribute = false;
        private String elementName;
        private String attributeName;
        private String attributeValue;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            isElement = true;
            isAttribute = false;
            elementName = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            isElement = false;
            isAttribute = false;
            elementName = "";
        }

        @Override
        public void characters(char[] chars, int start, int length) throws SAXException {
            if (isElement) {
                System.out.println("Element: " + elementName);
            } else if (isAttribute) {
                attributeName = new String(chars, start, length);
            } else {
                attributeValue += new String(chars, start, length);
            }
        }

        @Override
        public void startAttribute(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            isElement = false;
            isAttribute = true;
            attributeName = qName;
        }
    }
}