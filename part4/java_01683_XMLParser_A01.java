import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_01683_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "/path/to/your/xml/file"; // replace with your actual xml file path

        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser(null);

        MyHandler mh = new MyHandler();

        try {
            SAXParser saxParser = spf.newSAXParser(null);
            saxParser.parse(new FileInputStream(new File(xmlFile)), mh);
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            } else if (bName) {
                System.out.println("Name: " + localName);
                bName = false;
            } else if (bAge) {
                System.out.println("Age: " + localName);
                bAge = false;
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
                System.out.println("Name: " + new String(ch, start, length));
            } else if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }

    }
}