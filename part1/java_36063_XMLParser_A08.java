import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_36063_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();

            MyHandler handler = new MyHandler();
            saxParser.parse(new File("example.xml"), handler);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Start of Person : Name= " + localName);
                bName = true;
                bAge = false;
            } else if (bName && qName.equalsIgnoreCase("name")) {
                System.out.println("Name : " + localName);
                bName = false;
                bAge = false;
            } else if (bName && qName.equalsIgnoreCase("age")) {
                System.out.println("Age : " + localName);
                bAge = true;
                bName = false;
            } else if (bAge && qName.equalsIgnoreCase("age")) {
                System.out.println("Age : " + localName);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("End of Person : Name= " + localName);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName || bAge) {
                System.out.println("Character : " + new String(ch, start, length));
            }
        }
    }
}