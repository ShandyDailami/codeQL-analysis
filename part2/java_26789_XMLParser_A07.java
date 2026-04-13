import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_26789_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(xmlFile, handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
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
            if (qName.equalsIgnoreCase("Person")) {
                System.out.println("Start of person: " + localName);
                bName = true;
                bAge = false;
            } else if (bName && qName.equalsIgnoreCase("Name")) {
                System.out.println("Name: ");
                bName = false;
                bAge = false;
            } else if (bName && qName.equalsIgnoreCase("Age")) {
                System.out.println("Age: ");
                bName = false;
                bAge = true;
            } else if (bAge && qName.equalsIgnoreCase("Age")) {
                System.out.println("Age: ");
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("Person")) {
                System.out.println("End of person: " + localName);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println(new String(ch, start, length));
            }
        }
    }
}