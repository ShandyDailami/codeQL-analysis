import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_35498_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(true);

        File xmlFile = new File("sample.xml");
        BrokenAccessControlHandler brokenAccessControlHandler = new BrokenAccessControlHandler();

        try {
            saxParser.parse(xmlFile, brokenAccessControlHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class BrokenAccessControlHandler extends DefaultHandler {

        private boolean isUserDefined;
        private boolean isPasswordDefined;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("user")) {
                isUserDefined = true;
            } else if (qName.equals("password")) {
                isPasswordDefined = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("user")) {
                isUserDefined = false;
            } else if (qName.equals("password")) {
                isPasswordDefined = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isUserDefined && isPasswordDefined) {
                String password = new String(ch, start, length);
                System.out.println("Password found: " + password);
            }
        }
    }
}