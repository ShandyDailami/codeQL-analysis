import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.IOException;

public class java_39279_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("yourfile.xml"), new ParsingListener());

        } catch (SAXParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.print("Start Element : " + qName);
            if (qName.equalsIgnoreCase("Person")) {
                bName = true;
                bAge = true;
                System.out.print("Name : " + attributes.getValue("name"));
                System.out.println("Age : " + attributes.getValue("age"));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End Element : " + qName);
            if (qName.equalsIgnoreCase("Person")) {
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bName) {
                System.out.print("Name : " + new String(ch, start, length));
                bName = false;
            }
            if (bAge) {
                System.out.println("Age : " + new String(ch, start, length));
                bAge = false;
            }
        }

    }

    static class ParsingListener implements org.xml.sax.helpers.DefaultHandler {

        @Override
        public void startDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start Element : " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End Element : " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            System.out.println("Characters : " + new String(ch, start, length));
        }

    }

}