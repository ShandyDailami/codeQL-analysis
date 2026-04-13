import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_30230_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("broken-access-control.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean isUser;
        private boolean isRole;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("user")) {
                isUser = true;
            } else if (qName.equals("role")) {
                isRole = true;
            }
        }

        @Override
        public java_30230_XMLParser_A01(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("user")) {
                isUser = false;
            } else if (qName.equals("role")) {
                isRole = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isUser && !isRole) {
                String user = new String(ch, start, length);
                // Do some security-sensitive operation related to A01_BrokenAccessControl
                System.out.println("Found a user: " + user);
            }
        }
    }
}