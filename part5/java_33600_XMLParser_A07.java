import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_33600_XMLParser_A07 extends DefaultHandler {

    private boolean isAuthFailureElementFound = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("A07_AuthFailure")) {
            isAuthFailureElementFound = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("A07_AuthFailure")) {
            if (!isAuthFailureElementFound) {
                throw new SAXException("A07_AuthFailure element not found!");
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(Main.class.getClassLoader().getResource("file.xml"));
            parser.parse("file.xml", new AuthFailureHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}