import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_00465_XMLParser_A01 extends DefaultHandler {

    public static void main(String[] args) {
        String xml = "<doc>Bad things can happen</doc>";
        parse(xml);
    }

    private static void parse(String xml) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new Handler());
            parser.parse(new InputSource(new StringReader(xml)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // We are not doing anything with the start element so we can ignore it.
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // We are not doing anything with the end element so we can ignore it.
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // We are not doing anything with the characters so we can ignore it.
    }

    private static class Handler extends DefaultHandler {
        @Override
        public void warning(SAXParseException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }
}