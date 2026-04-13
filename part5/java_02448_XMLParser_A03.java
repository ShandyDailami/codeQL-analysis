import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_02448_XMLParser_A03 {

    public static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;
        private String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            currentElement = qName;
            if (qName.equals("person")) {
                bName = true;
                bAge = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String data = new String(ch, start, length);
            if (bName) {
                System.out.println("Name: " + data);
                bName = false;
            }
            if (bAge) {
                System.out.println("Age: " + data);
                bAge = false;
            }
        }
    }

    public static void main(String[] args) {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());

        String xml = "<people>\n" +
                "  <person>\n" +
                "    <name>John</name>\n" +
                "    <age>25</age>\n" +
                "  </person>\n" +
                "  <person>\n" +
                "    <name>Mary</name>\n" +
                "    <age>27</age>\n" +
                "  </person>\n" +
                "</people>";

        parser.parse(new StringReader(xml));
    }
}