import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import java.io.File;

public class java_24457_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("sample.xml"), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean isTitle = false;
        private boolean isLink = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                isTitle = true;
            } else if (qName.equalsIgnoreCase("link")) {
                isLink = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                isTitle = false;
            } else if (qName.equalsIgnoreCase("link")) {
                isLink = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isTitle) {
                // This is where you would process the title
                System.out.println("Title: " + new String(ch, start, length));
            } else if (isLink) {
                // This is where you would process the link
                System.out.println("Link: " + new String(ch, start, length));
            }
        }
    }
}