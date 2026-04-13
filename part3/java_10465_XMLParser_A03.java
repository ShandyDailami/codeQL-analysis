import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_10465_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("sample.xml"), false);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bElementName = false;
        boolean bElementValue = false;
        String currentValue = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("element")) {
                bElementName = true;
                bElementValue = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bElementName) {
                bElementName = false;
                currentValue = new String(ch, start, length);
            } else if (bElementValue) {
                currentValue += new String(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("element")) {
                bElementValue = true;
                System.out.println("Name: " + currentValue);
                System.out.println("Value: " + currentValue);
            }
        }
    }
}