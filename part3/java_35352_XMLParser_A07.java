import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;

public class java_35352_XMLParser_A07 {

    // SAX Parser
    public static void parse(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new StringReader(xml), new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handler
    static class MyHandler extends DefaultHandler {

        private boolean authFailure = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("AuthFailure")) {
                authFailure = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("AuthFailure")) {
                if (!authFailure) {
                    System.out.println("Security Warning: AuthFailure has not been detected.");
                } else {
                    System.out.println("Security Alert: AuthFailure has been detected.");
                }
                authFailure = false;
            }
        }
    }

    public static void main(String[] args) {
        String xml = "<root><AuthFailure /></root>"; // For example
        parse(xml);
    }
}