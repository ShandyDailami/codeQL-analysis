import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_20856_XMLParser_A01 {

    private static class MyHandler extends DefaultHandler {
        private boolean accessControlEnabled = false;
        private StringBuilder content = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("access")) {
                accessControlEnabled = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (accessControlEnabled) {
                content.append(new String(ch, start, length));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("access")) {
                String accessControl = content.toString();
                if (accessControl.contains("password")) {
                    System.out.println("Security alert: Found access control with sensitive information");
                }
                accessControlEnabled = false;
                content.setLength(0);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());
        parser.parse(XmlParser.class.getResourceAsStream("broken_access_control.xml"), MyHandler.class);
    }
}