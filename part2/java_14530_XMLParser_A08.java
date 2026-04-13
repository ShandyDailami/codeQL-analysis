import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_14530_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "user.xml"; // replace with your file
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File(xmlFile), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean usernameFound = false;
        private boolean passwordFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("username")) {
                usernameFound = true;
            } else if (qName.equalsIgnoreCase("password")) {
                passwordFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("username")) {
                usernameFound = false;
            } else if (qName.equalsIgnoreCase("password")) {
                passwordFound = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (usernameFound) {
                System.out.println("Username: " + new String(ch, start, length));
                usernameFound = false;
            } else if (passwordFound) {
                System.out.println("Password: " + new String(ch, start, length));
                passwordFound = false;
            }
        }
    }
}