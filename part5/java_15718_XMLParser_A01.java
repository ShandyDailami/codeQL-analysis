import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_15718_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(XMLParser.class.getResourceAsStream("/example.xml"), myHandler);
    }

    static class MyHandler extends DefaultHandler {
        boolean isTitle = false;
        boolean isLink = false;
        String title = null;
        String link = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                isTitle = true;
            } else if (qName.equalsIgnoreCase("link")) {
                isLink = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                isTitle = false;
            } else if (qName.equalsIgnoreCase("link")) {
                isLink = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isTitle) {
                title = new String(ch, start, length);
            } else if (isLink) {
                link = new String(ch, start, length);
            }
        }

        @Override
        public void endDocument() {
            System.out.println("Title: " + title);
            System.out.println("Link: " + link);
        }
    }
}