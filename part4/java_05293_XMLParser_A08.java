import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_05293_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null);
            MyHandler handler = new MyHandler();
            parser.parse("src/main/resources/test.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean integrityFailure = false;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start of element " + qName);
            // Add more checks if necessary
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of element " + qName);
            // Add more checks if necessary
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Chars in element: " + new String(ch, start, length));
            // Add more checks if necessary
        }

        @Override
        public void fatalError(SAXException e) throws SAXException {
            integrityFailure = true;
            System.out.println("Fatal error: " + e.getMessage());
        }
    }
}