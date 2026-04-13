import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_22266_XMLParser_A07 extends DefaultHandler {
    private static final String AUTH_FAILURE_TAG = "authFailure";
    private boolean authFailureFound = false;

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
        if (qualifiedName.equalsIgnoreCase(AUTH_FAILURE_TAG)) {
            authFailureFound = true;
        }
    }

    public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
        if (authFailureFound) {
            throw new AuthFailureException("Authentication failure detected");
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (authFailureFound) {
            String authFailureMessage = new String(ch, start, length);
            System.out.println("Authentication failure message: " + authFailureMessage);
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(parser);
            saxParser.parse(new File("src/main/resources/authFailure.xml"), parser);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}