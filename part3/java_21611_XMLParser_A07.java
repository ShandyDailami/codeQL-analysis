import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_21611_XMLParser_A07 extends DefaultHandler {
    private boolean authFailure = false;

    public java_21611_XMLParser_A07() {
        super();
    }

    public boolean isAuthFailure() {
        return authFailure;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equals("AuthenticationFailure")) {
            authFailure = true;
        }
    }

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<root>" +
                "    <AuthenticationFailure>" +
                "        <FailureType>AuthenticationFailed</FailureType>" +
                "    </AuthenticationFailure>" +
                "</root>";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(new InputSource(new StringReader(xml)));
            SecureXMLParser handler = new SecureXMLParser();
            parser.setContentHandler(handler);
            parser.parse(new InputSource(new StringReader(xml)));

            if (handler.isAuthFailure()) {
                System.out.println("Authentication failure detected!");
            } else {
                System.out.println("Authentication failure not detected!");
           
            }
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}