import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_30374_XMLParser_A03 {
    private static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;
        private String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            if (currentElement.equals("Person")) {
                bName = true;
                bAge = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String value = new String(ch, start, length);
            if (bName) {
                System.out.println("Name: " + value);
                bName = false;
            } else if (bAge) {
                System.out.println("Age: " + value);
                bAge = false;
            }
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser(null);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(args[0], myHandler);
    }
}