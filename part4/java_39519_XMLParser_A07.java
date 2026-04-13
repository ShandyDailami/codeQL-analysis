import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_39519_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(XMLParser.class.getResourceAsStream("/sample.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean authenticationFailure = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("AuthenticationFailure")) {
            authenticationFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("AuthenticationFailure")) {
            authenticationFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (authenticationFailure) {
            System.out.println("Authentication failure detected!");
        }
    }
}