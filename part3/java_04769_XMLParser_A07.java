import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_04769_XMLParser_A07 {
    public static void parse(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null);
            MyHandler handler = new MyHandler();
            saxParser.parse(xml, handler);
        } catch (Exception e) {
            System.out.println("Failed to parse the XML due to " + e.getMessage());
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bAuthFailure = false;
        boolean bUser = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("user")) {
                bUser = true;
            }
            if (qName.equalsIgnoreCase("authFailure")) {
                bAuthFailure = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (bAuthFailure && bUser) {
                System.out.println("Found authFailure and user in the XML");
            }
            bAuthFailure = false;
            bUser = false;
        }
    }

    public static void main(String[] args) {
        String xml = "<root><user></user><authFailure></authFailure></root>";
        parse(xml);
    }
}