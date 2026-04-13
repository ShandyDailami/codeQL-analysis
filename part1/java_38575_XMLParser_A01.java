import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_38575_XMLParser_A01 {

    public static class BrokenAccessControlHandler extends DefaultHandler {
        private boolean brokenAccessControl = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (brokenAccessControl) {
                throw new SAXException("Broken access control: attempt to access forbidden elements or attributes");
            }
        }

        public void setBrokenAccessControl(boolean brokenAccessControl) {
            this.brokenAccessControl = brokenAccessControl;
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(new InputSource(new File("example.xml")));

        BrokenAccessControlHandler handler = new BrokenAccessControlHandler();
        parser.parse(new InputSource(new File("example.xml")), handler);
    }
}