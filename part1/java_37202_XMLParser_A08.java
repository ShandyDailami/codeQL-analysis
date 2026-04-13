import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_37202_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null);

        Handler handler = new Handler();
        parser.parse("example.xml", handler);
    }

    static class Handler extends DefaultHandler {
        boolean bElement = false;
        String elementValue = "";
        String qName = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            bElement = true;
            this.qName = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bElement = false;
            this.qName = qName;

            if (bElement) {
                System.out.println("End Element: " + qName);
            } else {
                System.out.println("Element Value: " + elementValue);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bElement) {
                elementValue = new String(ch, start, length);
            }
        }
    }
}