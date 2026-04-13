import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_23398_XMLParser_A01 {
    private static class MyHandler extends DefaultHandler {
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start Element: " + localName);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + localName);
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Character Data: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser(null);

        MyHandler myHandler = new MyHandler();
        saxParser.parse("input.xml", myHandler);
    }
}