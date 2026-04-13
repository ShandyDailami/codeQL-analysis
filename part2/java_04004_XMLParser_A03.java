import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_04004_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("example.xml"), myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean bTitle = false;
        private boolean bLink = false;
        private String title = null;
        private String link = null;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            if (qName.equalsIgnoreCase("entry")) {
                bTitle = true;
            } else if (bTitle) {
                if (qName.equalsIgnoreCase("title")) {
                    bTitle = false;
                    bLink = false;
                    title = attributes.getValue("title");
                } else if (qName.equalsIgnoreCase("link")) {
                    bTitle = false;
                    bLink = true;
                    link = attributes.getValue("link");
                }
            }

        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("entry")) {
                System.out.println("Title: " + title);
                System.out.println("Link: " + link);
                bTitle = false;
                bLink = false;
                title = null;
                link = null;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTitle)
                title += new String(ch, start, length);
            if (bLink)
                link += new String(ch, start, length);
        }

    }

}