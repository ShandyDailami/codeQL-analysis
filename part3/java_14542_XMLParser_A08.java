import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_14542_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(XMLParser.class.getResourceAsStream("/sample.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder stringBuilder;
        private boolean bTag = false;
        private String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            stringBuilder = new StringBuilder();
            bTag = false;
            currentElement = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                stringBuilder.append(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (currentElement.equals("book")) {
                System.out.println("Title: " + stringBuilder.toString());
            } else if (currentElement.equals("price")) {
                System.out.println("Price: " + stringBuilder.toString());
            }
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            // Not used
        }

        @Override
        public void endPrefixMapping(String prefix) throws SAXException {
            // Not used
        }
    }
}