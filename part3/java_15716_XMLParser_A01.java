import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_15716_XMLParser_A01 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        XMLHandler handler = new XMLHandler();

        try {
            SAXParserFactory.newInstance().newSAXParser().parse(inputFile, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class XMLHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if ("person".equals(localName)) {
                bName = true;
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("person".equals(localName)) {
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