import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_23725_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null);
            MyHandler handler = new MyHandler();
            saxParser.parse(new File("example.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bTag = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bTag = true;
            }
        }

        @Override
        public java_23725_XMLParser_A01(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                bTag = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bTag) {
                String strChars = new String(ch, start, length);
                System.out.println("Characters = " + strChars);
            }
        }
    }
}