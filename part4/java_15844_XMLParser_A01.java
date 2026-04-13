import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_15844_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser sp = spf.newSAXParser(null);
            MyHandler mh = new MyHandler();
            sp.parse(new File("test.xml"), mh);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bTitle = false;
        boolean bLink = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("title")) {
                bTitle = true;
            } else if (qName.equals("link")) {
                bLink = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("title")) {
                bTitle = false;
            } else if (qName.equals("link")) {
                bLink = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTitle) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (bLink) {
                System.out.println("Link: " + new String(ch, start, length));
            }
        }
    }
}