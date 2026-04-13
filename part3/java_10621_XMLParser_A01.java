import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_10621_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        Handler handler = new Handler();
        saxParser.parse(XmlParser.class.getResourceAsStream("/sample.xml"), handler);
    }

    static class Handler extends DefaultHandler {

        private boolean name;
        private boolean location;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                name = true;
                location = false;
            } else if (qName.equalsIgnoreCase("location")) {
                location = true;
                name = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (name) {
                System.out.println("Name: " + new String(ch, start, length));
                name = false;
            } else if (location) {
                System.out.println("Location: " + new String(ch, start, length));
                location = false;
            }
        }
    }
}