import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_26410_XMLParser_A01 {

    public static void main(String[] args) {
        String xml = "<root><element1>Content1</element1><element2>Content2</element2></root>";

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler handler = new MyHandler();
            saxParser.parse(new StringReader(xml), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private String lastElement = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals(lastElement)) {
                System.out.println("End of " + lastElement);
                lastElement = null;
            } else {
                System.out.println("Start of " + lastElement + " within " + qName);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (lastElement != null) {
                System.out.println("Character data: " + new String(ch, start, length));
            }
        }

    }

}