import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_16875_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null);
            MyHandler handler = new MyHandler();

            saxParser.parse("src/resources/authfailure.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean usernameFound = false;
        private boolean passwordFound = false;
        private String username = null;
        private String password = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("username")) {
                usernameFound = true;
            } else if (qName.equalsIgnoreCase("password")) {
                passwordFound = true;
            }
        }

        @Override
        public void characters(char[] chars, int start, int length) throws SAXException {
            if (usernameFound) {
                username = new String(chars, start, length);
                usernameFound = false;
            } else if (passwordFound) {
                password = new String(chars, start, length);
                passwordFound = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("username")) {
                System.out.println("Username: " + username);
            } else if (qName.equalsIgnoreCase("password")) {
                System.out.println("Password: " + password);
            }
        }
    }
}