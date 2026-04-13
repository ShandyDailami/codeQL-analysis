import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_11737_XMLParser_A07 {

    public static void main(String[] args) {
        String xml = "<data><username>admin</username><password>password</password></data>";

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            SecureHandler handler = new SecureHandler();
            parser.parse(new StringReader(xml), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SecureHandler extends DefaultHandler {

        boolean usernameFound = false;
        boolean passwordFound = false;

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
            } else if (passwordFound) {
                System.out.println("Password: " + new String(ch, start, length));
            }
        }
    }
}