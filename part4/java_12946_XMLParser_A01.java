import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_12946_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(null);

            MyHandler mh = new MyHandler();
            sp.parse(new InputSource(new StringReader("<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend.</body></note>")), mh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder data = new StringBuilder();

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            data.setLength(0);
            System.out.println("Start Element: " + qName);
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            data.append(ch, start, length);
            System.out.println("Character Data: " + data.toString());
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + qName);
            System.out.println("Element Data: " + data.toString());
        }
    }
}