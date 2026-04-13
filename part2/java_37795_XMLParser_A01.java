import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_37795_XMLParser_A01 {

    public static void main(String[] args) {
        String xml = "<document>\n" +
                "  <person id='1'>\n" +
                "    <name>John</name>\n" +
                "    <age>30</age>\n" +
                "  </person>\n" +
                "  <person id='2'>\n" +
                "    <name>Jane</name>\n" +
                "    <age>25</age>\n" +
                "  </person>\n" +
                "</document>";

        parseXML(xml);
    }

    private static void parseXML(String xml) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(xml, myHandler);
    }

    private static class MyHandler extends DefaultHandler {
        private boolean nameFound = false;
        private boolean ageFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("name")) {
                nameFound = true;
            } else if (qName.equals("age")) {
                ageFound = true;
            }
        }

        @Override
        public void characters(char[] chars, int start, int length) throws SAXException {
            if (nameFound) {
                System.out.println("Name: " + new String(chars, start, length));
                nameFound = false;
            } else if (ageFound) {
                System.out.println("Age: " + new String(chars, start, length));
                ageFound = false;
            }
        }
    }
}