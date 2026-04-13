import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_27175_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new FileInputStream("src/resources/security.xml"), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean isAuthFailure = false;
        private boolean isSecurity = false;
        private List<String> authFailures = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("AuthFailure")) {
                isAuthFailure = true;
            } else if (qName.equals("Security")) {
                isSecurity = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("AuthFailure")) {
                isAuthFailure = false;
            } else if (qName.equals("Security")) {
                isSecurity = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isAuthFailure && isSecurity) {
                authFailures.add(new String(ch, start, length));
            }
        }
    }
}