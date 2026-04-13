import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_12380_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bValue = false;
        String curName = "";
        String curValue = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("NAME")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("VALUE")) {
                bValue = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("NAME")) {
                bName = false;
            } else if (qName.equalsIgnoreCase("VALUE")) {
                bValue = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                curName = new String(ch, start, length);
            } else if (bValue) {
                curValue = new String(ch, start, length);
            }
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("Name: " + curName + ", Value: " + curValue);
        }
    }
}