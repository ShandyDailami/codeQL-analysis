import java.security.Security;
import java.util.logging.Logger;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_14878_XMLParser_A07 {

    private static final Logger LOGGER = Logger.getLogger(MyXMLParser.class.getName());

    public static void main(String[] args) {
        // Add your XML security manager
        Security.addProvider(new MyXmlSecurityProvider());

        try {
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser(true);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(MyXMLParser.class.getResourceAsStream("/test.xml"), myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private StringBuilder sb = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            sb.setLength(0);
            sb.append("Start Element: ").append(qName);
            print(sb.toString());
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            sb.setLength(0);
            sb.append("End Element: ").append(qName);
            print(sb.toString());
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            sb.setLength(0);
            sb.append("Character Data: ").append(new String(ch, start, length));
            print(sb.toString());
        }

        private void print(String text) {
            LOGGER.info(text);
        }
    }
}