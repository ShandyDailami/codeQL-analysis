import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_27879_XMLParser_A03 {

    // Define the SAX parser
    private static SAXParser saxParser;

    // Define the handler for SAX events
    private static MyHandler myHandler = new MyHandler();

    // Initialize the SAX parser
    static {
        try {
            saxParser = SAXParserFactory.newInstance().newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static void parse(String fileName) {
        saxParser.parse(fileName, myHandler);
    }

    // Define the SAX handler
    private static class MyHandler extends DefaultHandler {

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Parsing started.");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("Parsing ended.");
        }

        @Override
        public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qualifiedName);
        }

        @Override
        public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
            System.out.println("End element: " + qualifiedName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        @Override
        public void fatalError(String error) throws SAXException {
            System.out.println("Fatal error: " + error);
        }

        @Override
        public void error(String error) throws SAXException {
            System.out.println("Error: " + error);
        }
    }
}