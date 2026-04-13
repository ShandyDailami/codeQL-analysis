import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_35524_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null);
            MyHandler handler = new MyHandler();
            parser.parse("resources/example.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bNodeFound = false;
        String thisValue = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("node")) {
                bNodeFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("node")) {
                System.out.println("Value: " + thisValue);
                bNodeFound = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bNodeFound) {
                thisValue = new String(ch, start, length);
            }
        }
    }
}