import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_40565_XMLParser_A01 {
    public static class MyHandler extends DefaultHandler {
        private String lastTag;
        private boolean nameTagFound = false;
        private boolean numberTagFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastTag = qName;
            if (qName.equals("name")) {
                nameTagFound = true;
            } else if (qName.equals("number")) {
                numberTagFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                if (!nameTagFound || !numberTagFound) {
                    System.out.println("Access Denied: Missing 'name' or 'number'!");
                } else {
                    System.out.println("Access Granted: All information is present!");
                }
                nameTagFound = false;
                numberTagFound = false;
            }
            lastTag = "";
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        saxParser.parse(CustomXMLParser.class.getResourceAsStream("sample.xml"), handler);
    }
}