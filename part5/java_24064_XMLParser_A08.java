import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_24064_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MyHandler handler = new MyHandler();
        parser.parse("input.xml", handler);
    }

    static class MyHandler extends DefaultHandler {
        boolean isInElement = false;
        String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            isInElement = true;
            currentElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            isInElement = false;
            currentElement = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isInElement) {
                String content = new String(ch, start, length);
                // Simple integrity check: check if the content is not empty.
                if (!content.trim().isEmpty()) {
                    System.out.println("Integrity failure in element: " + currentElement + ", content: " + content);
                }
            }
        }
    }
}