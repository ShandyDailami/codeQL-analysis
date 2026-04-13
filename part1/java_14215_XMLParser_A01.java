import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_14215_XMLParser_A01 {

    public static class MyHandler extends DefaultHandler {
        private String lastElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            lastElement = qName;
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            lastElement = null;
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (lastElement != null) {
                System.out.println("Character data: " + new String(ch, start, length));
            }
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());

            saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}