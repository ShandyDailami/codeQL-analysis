import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_23910_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("sample.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean isUsername = false;
        private boolean isPassword = false;
        private String username = null;
        private String password = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("username")) {
                isUsername = true;
            } else if (qName.equalsIgnoreCase("password")) {
                isPassword = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isUsername) {
                username = new String(ch, start, length);
                isUsername = false;
            } else if (isPassword) {
                password = new String(ch, start, length);
                isPassword = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("user")) {
                if (username != null && password != null) {
                    // Here you can handle the authentication failure
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                } else {
                    System.out.println("Username or password is not found!");
                }
            }
        }
    }
}