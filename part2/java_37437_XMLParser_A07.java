import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_37437_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXHandler myHandler = new SAXHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(myHandler);
            reader.parse("src/input.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    boolean bAuthenticationFailed = false;
    boolean bAuthSuccess = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("Authentication")) {
            // Start authentication
            // Check authentication against a security source.
            // If failed, set bAuthSuccess to false and bAuthenticationFailed to true.
            // If successful, set bAuthSuccess and bAuthenticationFailed to true.
            bAuthSuccess = false;
            bAuthenticationFailed = true;
        } else if (qName.equalsIgnoreCase("Success")) {
            // Authentication successful.
            bAuthenticationFailed = false;
            bAuthSuccess = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // End of authentication
        // If authentication failed, print a failure message
        if (bAuthenticationFailed) {
            System.out.println("Authentication failed");
        }
        // If authentication was successful, print a success message
        else if (bAuthSuccess) {
            System.out.println("Authentication successful");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Not used in this example
    }
}