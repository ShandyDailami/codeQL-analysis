import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

import java.util.HashMap;
import java.util.Map;

public class java_09342_XMLParser_A07 extends DefaultHandler {
    private static final String USERS = "users";
    private static final String USER = "user";
    private static final String NAME = "name";
    private static final String PASSWORD = "password";

    private Map<String, String> users = new HashMap<>();
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(USERS)) {
            // Process all users
        } else if (qName.equals(USER)) {
            // Process a user
        } else if (currentElement.equals(NAME)) {
            // Save the username
        } else if (currentElement.equals(PASSWORD)) {
            // Save the password
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement != null && currentElement.equals(PASSWORD)) {
            String password = new String(ch, start, length);
            // Save password securely (encryption, hash, etc.)
        }
    }

    public Map<String, String> getUsers() {
        return users;
    }
}