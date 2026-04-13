import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_16218_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new SAXHandler());
            saxParser.parse("src/main/resources/authFailure.xml", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {

        private boolean usernameFound = false;
        private boolean passwordFound = false;
        private String username = null;
        private String password = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("username")) {
                usernameFound = true;
            } else if (qName.equals("password")) {
                passwordFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("username")) {
                usernameFound = false;
            } else if (qName.equals("password")) {
                passwordFound = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (usernameFound) {
                username = new String(ch, start, length);
            } else if (passwordFound) {
                password = new String(ch, start, length);
            }
        }

        public void authFailureFound() {
            // Do some security sensitive operation
            System.out.println("Username: " + username + ", Password: " + password);
        }
    }
}