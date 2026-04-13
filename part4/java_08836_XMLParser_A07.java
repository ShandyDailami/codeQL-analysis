import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_08836_XMLParser_A07 {

    public static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;
        private String currentElement = "";

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            if (qName.equalsIgnoreCase("student")) {
                bName = true;
                bAge = true;
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentElement = "";
            if (qName.equalsIgnoreCase("student")) {
                bName = false;
                bAge = false;
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name : " + new String(ch, start, length));
                bName = false;
            }
            if (bAge) {
                System.out.println("Age : " + new String(ch, start, length));
                bAge = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        MyHandler mh = new MyHandler();
        sp.parse(new InputSource(new StringReader("<students><student><name>John</name><age>25</age></student><student><name>Mary</name><age>27</age></student></students>")), mh);
    }
}