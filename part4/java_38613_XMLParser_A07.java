import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_38613_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(new File("sample.xml"), handler);

            System.out.println("Username: " + handler.getUsername());
            System.out.println("Password: " + handler.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private String username;
        private String password;
        private boolean readingUsername;
        private boolean readingPassword;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("username")) {
                readingUsername = true;
            } else if (qName.equalsIgnoreCase("password")) {
                readingPassword = true;
            }
        }

        @Override
        public void characters(char[] chars, int start, int length) throws SAXException {
            if (readingUsername) {
                username = new String(chars, start, length);
                readingUsername = false;
            } else if (readingPassword) {
                password = new String(chars, start, length);
                readingPassword = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("username")) {
                readingUsername = false;
            } else if (qName.equalsIgnoreCase("password")) {
                readingPassword = false;
            }
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}