import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_40911_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            File xmlFile = new File("input.xml");
            parser.parse(xmlFile, MyHandler.getContentHandler());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private static final String LOGGED_IN = "loggedIn";
        private static final String USERNAME = "username";
        private static final String PASSWORD = "password";
        private boolean loggedIn = false;
        private String username = null;
        private String password = null;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            System.out.println("Start of element : " + qName);
            if (qName.equals(LOGGED_IN)) {
                loggedIn = true;
            } else if (qName.equals(USERNAME)) {
                username = attributes.getValue(0);
            } else if (qName.equals(PASSWORD)) {
                password = attributes.getValue(0);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of element : " + qName);
            if (qName.equals(LOGGED_IN) && loggedIn) {
                System.out.println("Logged in as : " + username);
                System.out.println("Password is : " + password);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (loggedIn) {
                System.out.println("Character data : " + new String(ch, start, length));
            }
        }
    }
}