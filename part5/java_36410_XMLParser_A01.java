import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_36410_XMLParser_A01 {

    public static void parse(String xml) throws SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());
        parser.parse(xml, MyHandler.getHandlerInstance());
    }

    static class MyHandler extends DefaultHandler {
        private static MyHandler handlerInstance;

        public static MyHandler getHandlerInstance() {
            if (handlerInstance == null) {
                handlerInstance = new MyHandler();
            }
            return handlerInstance;
        }

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
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String value = new String(ch, start, length);
            System.out.println("Character data: " + value);
        }

        @Override
        public void error(SAXException e) {
            System.err.println("Error: " + e);
        }

        @Override
        public void fatalError(SAXException e) {
            System.err.println("Fatal error: " + e);
        }

        @Override
        public void warning(SAXException e) {
            System.err.println("Warning: " + e);
        }
    }

    public static void main(String[] args) {
        String xml = "<root><element1>Content 1</element1><element2>Content 2</element2></root>";
        try {
            parse(xml);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}