import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_38479_XMLParser_A01 {
    public static void main(String[] args) {
        String filePath = "your_xml_file.xml"; // replace with your xml file path
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File(filePath), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean isTitle = false;
        private boolean isLink = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                isTitle = true;
            } else if (qName.equalsIgnoreCase("link")) {
                isLink = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (isTitle) {
                System.out.println("Title: " + qName);
                isTitle = false;
            } else if (isLink) {
                System.out.println("Link: " + qName);
                isLink = false;
            }
        }
    }
}