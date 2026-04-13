import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_00562_XMLParser_A08 {

    public static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            } else if (bName && qName.equalsIgnoreCase("name")) {
                bName = false;
            } else if (bName && qName.equalsIgnoreCase("age")) {
                bAge = false;
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = false;
                bAge = false;
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                String data = new String(ch, start, length);
                System.out.println("Name: " + data);
            } else if (bAge) {
                String data = new String(ch, start, length);
                System.out.println("Age: " + data);
            }
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(null);
            MyHandler mh = new MyHandler();
            sp.parse(new InputSource(new StringReader("<people><person><name>John</name><age>30</age></person><person><name>Jane</name><age>28</age></person></people>")), mh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}