import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_18724_XMLParser_A07 {

    public static void parseXML(String fileName) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(fileName, myHandler);
    }

    // Define a handler for SAX events
    public static class MyHandler extends DefaultHandler {

        private boolean isAuthFailure;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("AuthFailure")) {
                isAuthFailure = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("AuthFailure")) {
                if (isAuthFailure) {
                    System.out.println("Security sensitive operation related to A07_AuthFailure detected.");
                }
                isAuthFailure = false;
            }
        }
    }

    public static void main(String[] args) {
        parseXML("security-sensitive-operations.xml");
    }
}