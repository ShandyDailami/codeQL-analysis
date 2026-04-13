import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_14963_XMLParser_A07 {

    public static class XmlHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("Person")) {
                bName = true;
                bAge = true;
            } else if (bName) {
                if (qName.equals("Name")) {
                    bName = false;
                }
            } else if (bAge) {
                if (qName.equals("Age")) {
                    bAge = false;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("Person")) {
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                String value = new String(ch, start, length).trim();
                if (!value.isEmpty()) {
                    System.out.println("Name: " + value);
                }
            } else if (bAge) {
                String value = new String(ch, start, length).trim();
                if (!value.isEmpty()) {
                    System.out.println("Age: " + value);
                }
            }
        }
    }

    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser(null);
        XmlHandler xh = new XmlHandler();
        sp.parse("src/main/resources/data.xml", xh);
    }
}