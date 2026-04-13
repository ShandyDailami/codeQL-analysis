import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_40928_XMLParser_A07 extends DefaultHandler {

    private boolean isAuthFailure = false;
    private StringBuffer buffer = new StringBuffer();

    public static void main(String[] args) {
        SecureXMLParser parser = new SecureXMLParser();
        parser.parse(SecureXMLParser.class.getResourceAsStream("/sample.xml"));
    }

    public void parse(InputStream input) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(new InputSource(input));
            parser.parse(this, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer = new StringBuffer();
        if (qName.equals("authFailure")) {
            isAuthFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isAuthFailure) {
            // handle security-sensitive operation related to A07_AuthFailure
            System.out.println("Security-sensitive operation related to A07_AuthFailure: " + buffer.toString());
            isAuthFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(new String(ch, start, length));
    }
}