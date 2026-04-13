import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_07766_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(new MyContentHandler());
            xr.parse("src/main/resources/brokenaccesscontrol.xml");
        } catch (SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    static class MyContentHandler extends DefaultHandler {
        boolean accessControl = false;

        @Override
        public void startDocument() throws SAXException {
            accessControl = true;
        }

        @Override
        public void endDocument() throws SAXException {
            if (!accessControl) {
                throw new SAXException("Access control not found in document");
            }
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("accessControl".equals(qName)) {
                accessControl = true;
            }
        }

        @Override
        public java_07766_XMLParser_A01(String uri, String localName, String qName) throws SAXException {
            if ("accessControl".equals(qName)) {
                accessControl = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (accessControl) {
                // Security sensitive operation here
                System.out.println(new String(ch, start, length));
            }
        }
    }
}