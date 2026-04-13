import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_21071_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler());
            parser.parse("example.xml", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class SAXHandler extends DefaultHandler {
        private boolean nameFound = false;
        private boolean valueFound = false;
        private String currentElement = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            nameFound = true;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentElement = null;
            if (qName.equals("name")) {
                valueFound = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (nameFound && valueFound) {
                System.out.println("Name: " + new String(ch, start, length));
                nameFound = false;
                valueFound = false;
            }
        }
    }
}