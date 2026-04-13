import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_37241_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean bUsername = false;
        private boolean bPassword = false;
        private String username = null;
        private String password = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("user")) {
                bUsername = true;
            }
            if (qName.equals("password")) {
                bPassword = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bUsername) {
                username = new String(ch, start, length);
                bUsername = false;
            } else if (bPassword) {
                password = new String(ch, start, length);
                bPassword = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equals("user")) {
                // Perform authentication operation
                authenticate(username, password);
            }
        }

        private void authenticate(String username, String password) {
            // Perform security-sensitive operations here
            // ...
        }
    }
}