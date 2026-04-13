import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_35446_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxFactory.newSAXParser(false);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("authFailure.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean inUserName = false;
        private boolean inPassword = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("username")) {
                inUserName = true;
            } else if (qName.equalsIgnoreCase("password")) {
                inPassword = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("username")) {
                inUserName = false;
            } else if (qName.equalsIgnoreCase("password")) {
                inPassword = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (inUserName) {
                // Handle username here
                System.out.println("Username: " + new String(ch, start, length));
            } else if (inPassword) {
                // Handle password here
                System.out.println("Password: " + new String(ch, start, length));
            }
        }
    }
}