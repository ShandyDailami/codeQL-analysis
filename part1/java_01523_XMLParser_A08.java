import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_01523_XMLParser_A08 {
    public static class MyHandler extends DefaultHandler {
        boolean bInName = false;
        boolean bInValue = false;
        String currentValue = null;

        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("element")) {
                bInName = true;
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("element")) {
                bInName = false;
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bInName) {
                currentValue = new String(ch, start, length);
            }
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);
        MyHandler myHandler = new MyHandler();

        saxParser.parse("example.xml", myHandler);
    }
}