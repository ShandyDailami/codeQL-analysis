import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXParserFactory;

import javax.xml.parsers.SAXParser;
import java.io.File;

public class java_12209_XMLParser_A07 {

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(true);

        MyHandler handler = new MyHandler();
        saxParser.parse(new File("sample.xml"), handler);
    }

    static class MyHandler extends DefaultHandler {

        private boolean isAuthor;
        private boolean isName;
        private boolean isAge;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("Author")) {
                isAuthor = true;
            } else if (qName.equalsIgnoreCase("Name")) {
                isName = true;
            } else if (qName.equalsIgnoreCase("Age")) {
                isAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("Author")) {
                isAuthor = false;
            } else if (qName.equalsIgnoreCase("Name")) {
                isName = false;
            } else if (qName.equalsIgnoreCase("Age")) {
                isAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isAuthor) {
                System.out.println("Author: " + new String(ch, start, length));
            } else if (isName) {
                System.out.println("Name: " + new String(ch, start, length));
            } else if (isAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }
}