import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_01271_XMLParser_A07 extends DefaultHandler {

    private static final String AUTH_FAILURE = "A07_AuthFailure";
    private boolean isAuthFailure = false;

    public java_01271_XMLParser_A07() {
        super();
    }

    @Override
    public void startDocument() throws SAXException {
        // Clean code: start by creating an object when needed
        System.out.println("Starting parsing...");
    }

    @Override
    public void startElement(String uri, String localName, String qName) throws SAXException {
        if (AUTH_FAILURE.equals(localName)) {
            isAuthFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isAuthFailure) {
            System.out.println("Authentication failure detected!");
            // Clean code: be creative and make it work for your application
            System.exit(-1);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of parsing...");
    }

    public static void main(String[] args) {
        // Clean code: start by creating an object when needed
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new SecureXMLParser());
        reader.parse("src/main/resources/authfailure.xml");
    }
}