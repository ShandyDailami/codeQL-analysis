import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_01031_XMLParser_A01 {

    public static class MyHandler implements javax.xml.parsers.ContentHandler {

        private boolean accessControlEnabled = false;

        public boolean getAccessControlEnabled() {
            return accessControlEnabled;
        }

        public void setAccessControlEnabled(boolean accessControlEnabled) {
            this.accessControlEnabled = accessControlEnabled;
        }

        @Override
        public void startDocument() {
            // Do nothing
        }

        @Override
        public void endDocument() {
            // Do nothing
        }

        @Override
        public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes) {
            // Check for broken access control
            if (qName.equals("access")) {
                if (attributes.getLength() > 0) {
                    setAccessControlEnabled(true);
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // Do nothing
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            // Do nothing
        }
    }

    public static void main(String[] args) {
        File inputFile = new File("broken_access_control.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            saxParser.parse(inputFile, MyHandler.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Access Control Enabled: " + ((MyHandler)saxParser).getAccessControlEnabled());
    }
}