import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_39077_XMLParser_A07 extends DefaultHandler {

    private boolean loginRequest = false;
    private boolean passwordRequest = false;
    private boolean usernameRequest = false;

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("LoginRequest")) {
            loginRequest = true;
        } else if (qName.equalsIgnoreCase("PasswordRequest")) {
            passwordRequest = true;
        } else if (qName.equalsIgnoreCase("UsernameRequest")) {
            usernameRequest = true;
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("LoginRequest")) {
            loginRequest = false;
        } else if (qName.equalsIgnoreCase("PasswordRequest")) {
            passwordRequest = false;
        } else if (qName.equalsIgnoreCase("UsernameRequest")) {
            usernameRequest = false;
        }
    }

    public void endDocument() {
        System.out.println("End of document");
    }

    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length);

        if (loginRequest) {
            System.out.println("Attempting to log in with username: " + data);
        } else if (passwordRequest) {
            System.out.println("Attempting to log in with password: " + data);
        } else if (usernameRequest) {
            System.out.println("Attempting to log in with username: " + data);
        }
    }
}