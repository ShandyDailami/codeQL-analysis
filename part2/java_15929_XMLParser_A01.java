import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_15929_XMLParser_A01 {

    // A simple SAX handler to parse XML
    private static class MySAXHandler extends DefaultHandler {
        private boolean tagName = false;
        private StringBuilder content;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("tag")) {
                tagName = true;
                content = new StringBuilder();
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (tagName) {
                content.append(new String(ch, start, length));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("tag")) {
                System.out.println(content.toString());
                tagName = false;
                content = null;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MySAXHandler());

        // Use the SAX parser to parse an XML document
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("broken_access_control.xml"), true);
    }
}