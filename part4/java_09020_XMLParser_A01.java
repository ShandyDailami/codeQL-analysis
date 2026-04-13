import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_09020_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("your_file.xml");

            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(xmlFile.getContentResolver());

            MyHandler myHandler = new MyHandler();
            saxParser.parse(xmlFile, myHandler);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
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

            if (isTitle) {
                System.out.println("Title: " + qName);
                isTitle = false;
            } else if (isLink) {
                System.out.println("Link: " + qName);
                isLink = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isTitle || isLink) {
                System.out.println("Content: " + new String(ch, start, length));
            }
        }
    }
}