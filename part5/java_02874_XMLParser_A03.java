import javax.xml.validation.Validator;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_02874_XMLParser_A03 {
    public static void validate(String xmlContent) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        parser.parse(new StringReader(xmlContent), handler);
    }

    private static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Do not do anything here, as the purpose is to secure against injection attacks.
            // This method is empty and does not do anything.
        }
    }
}