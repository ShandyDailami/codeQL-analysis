import java.security.AccessControlException;
import java.security.AccessControlListener;
import java.security.AccessControlContext;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_36675_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(new DTDHandler());

        try {
            saxParser.parse("src/main/resources/sample.xml", true);
        } catch (SAXException | AccessControlException e) {
            e.printStackTrace();
        }
    }

    static class DTDHandler extends DefaultHandler {
        private AccessControlContext acContext;

        public java_36675_XMLParser_A01() {
            this.acContext = new AccessControlContext();
            this.acContext.getAcceptAll();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (acContext.getAcceptAll() != AccessControlContext.ACCESS_ALLOWED) {
                throw new AccessControlException("Access Denied");
            }
        }
    }
}