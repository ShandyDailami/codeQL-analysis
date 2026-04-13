import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLValidator;
import org.xml.sax.util.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_18452_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(new org.xml.sax.InputSource(new File(xmlFile)));
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File(xmlFile), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

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
            System.out.println("Start Element: " + qName);
            if (qName.equals("person")) {
                bName = true;
                bAge = true;
                System.out.println("Name and Age");
            } else if (bName) {
                System.out.println("Name: " + localName);
                bName = false;
            } else if (bAge) {
                System.out.println("Age: " + attributes.getValue(0));
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.print("Name: ");
                System.out.println(new String(ch, start, length));
                bName = false;
            } else if (bAge) {
                System.out.print("Age: ");
                System.out.println(new String(ch, start, length));
                bAge = false;
            }
        }
    }
}