import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_38223_XMLParser_A07 extends DefaultHandler {
    private boolean isUsername = false;
    private boolean isPassword = false;
    private String username = null;
    private String password = null;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("username")) {
            isUsername = true;
        } else if (qName.equals("password")) {
            isPassword = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("username")) {
            isUsername = false;
        } else if (qName.equals("password")) {
            isPassword = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isUsername) {
            username = new String(ch, start, length);
        } else if (isPassword) {
            password = new String(ch, start, length);
        }
    }

    public void authenticate(String user, String pass) {
        if (user.equals(username) && pass.equals(password)) {
            System.out.println("Authentication successful!");
        } else {
            throw new SecurityException("Authentication failed!");
        }
    }
}