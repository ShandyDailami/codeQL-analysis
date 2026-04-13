import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_27611_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("sample.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder sb = new StringBuilder();

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
            System.out.print("Start of element: " + qName);
            sb.setLength(0); // clear the string builder
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of element: " + qName);
            System.out.println("Element content: " + sb.toString());
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Element content: " + new String(ch, start, length));
            sb.append(new String(ch, start, length));
        }
    }
}