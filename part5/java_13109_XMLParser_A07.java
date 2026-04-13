import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_13109_XMLParser_A07 extends DefaultHandler {

    private boolean userNameFound = false;
    private boolean passwordFound = false;
    private String lastElement = null;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
        if (qName.equalsIgnoreCase("username")) {
            userNameFound = true;
        } else if (qName.equalsIgnoreCase("password")) {
            passwordFound = true;
        } else {
            // Ignore other tags
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastElement = null;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement != null) {
            if (userNameFound) {
                // Here you can add the authentication logic, check if the user's password matches
                // if not, throw an exception to signify an auth failure
            } else if (passwordFound) {
                // Here you can add the authentication logic, check if the password is strong enough
                // if not, throw an exception to signify an auth failure
            }
        }
    }
}