import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_31854_XMLParser_A07 {

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null);

        InputStream inputStream = new FileInputStream(new File("input.xml"));
        parser.parse(inputStream, new MyHandler());
    }

    static class MyHandler extends DefaultHandler {
        private String lastElement = null;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElement = qName;
            System.out.println("Start of " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            lastElement = null;
            System.out.println("End of " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (lastElement != null) {
                System.out.println("Character data: " + new String(ch, start, length));
                lastElement = null;
            }
        }
    }
}