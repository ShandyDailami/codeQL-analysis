import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_06955_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("example.xml"), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            }
            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            }
            if (qName.equalsIgnoreCase("age")) {
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                String sName = new String(ch, start, length);
                System.out.println("Name: " + sName);
            }
            if (bAge) {
                String sAge = new String(ch, start, length);
                System.out.println("Age: " + sAge);
            }
        }
    }
}