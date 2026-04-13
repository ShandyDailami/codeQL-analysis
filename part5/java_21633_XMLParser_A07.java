import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_21633_XMLParser_A07 extends DefaultHandler {
    private boolean usernameFound = false;
    private boolean passwordFound = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("username")) {
            usernameFound = true;
        } else if (qName.equals("password")) {
            passwordFound = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (usernameFound && passwordFound) {
            // If username and password are found, check them.
            // For example, check if they match a hardcoded list of failed logins.
            // This is a security-sensitive operation, so it should be done in a secure way.
            if (passwordFound) {
                // Check password here.
                // For example, check if it matches a hardcoded list of failed logins.
            }
            if (usernameFound) {
                // Check username here.
                // For example, check if it matches a hardcoded list of failed logins.
            }
        }
    }
}