import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_29978_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new XmlHandler());
            parser.parse(new File("sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XmlHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;
        private boolean bId = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("student")) {
                bName = true;
                bAge = true;
                bId = true;
            } else if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("age")) {
                bAge = true;
            } else if (qName.equalsIgnoreCase("id")) {
                bId = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("student")) {
                bName = false;
                bAge = false;
                bId = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                String name = new String(ch, start, length);
                System.out.println("Name: " + name);
            } else if (bAge) {
                String age = new String(ch, start, length);
                System.out.println("Age: " + age);
            } else if (bId) {
                String id = new String(ch, start, length);
                System.out.println("Id: " + id);
            }
        }
    }
}