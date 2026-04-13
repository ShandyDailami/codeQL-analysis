import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_34127_XMLParser_A07 {
    private static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        public void startDocument() throws SAXException {
        }

        public void endDocument() throws SAXException {
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            } else if (bName && qName.equalsIgnoreCase("name")) {
                System.out.println("Name: ");
                bName = false;
            } else if (bName && qName.equalsIgnoreCase("age")) {
                System.out.println("Age: ");
                bAge = false;
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bAge) {
                System.out.println(new String(ch, start, length));
                bAge = false;
            }
        }
    }

    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser saxParser = spf.newSAXParser();
        MyHandler handler = new MyHandler();
        try {
            saxParser.parse(new File("src/main/resources/people.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}