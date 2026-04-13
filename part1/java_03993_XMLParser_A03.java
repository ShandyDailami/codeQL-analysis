import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_03993_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse("src/main/resources/secure_file.xml", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean element = false;
        private boolean attribute = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("element")) {
                element = true;
            } else if (qName.equalsIgnoreCase("attribute")) {
                attribute = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("element")) {
                element = false;
            } else if (qName.equalsIgnoreCase("attribute")) {
                attribute = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (element || attribute) {
                String content = new String(ch, start, length);
                System.out.println("Content: " + content);
            }
        }
    }
}