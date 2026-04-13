import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_36899_XMLParser_A07 extends DefaultHandler {
    private boolean authenticationFailure = false;

    public java_36899_XMLParser_A07() {
        // Create the parser
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = spf.newSAXParser(true);
            saxParser.parse("config.xml", this);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    // Implement the SAX parsing methods
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("authenticationFailure")) {
            authenticationFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("authenticationFailure")) {
            if (authenticationFailure) {
                System.out.println("Authentication failure detected!");
                // Add code to handle authentication failure
            } else {
                System.out.println("Authentication failure not detected!");
            }
        }
    }
}