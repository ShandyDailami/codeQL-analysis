import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_38170_XMLParser_A01 {

    // Implement a SAX parser with a SAXHandler
    public void parse(String file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(true);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(file, myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Implement a SAX handler
    private class MyHandler extends DefaultHandler {

        @Override
        public void startDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        @Override
        public void fatalError(SAXException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }

        @Override
        public void warning(SAXWarning e) {
            System.out.println("Warning: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new SecureSAXParser().parse("sample.xml");
    }
}