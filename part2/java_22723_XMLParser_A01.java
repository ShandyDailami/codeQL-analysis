import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_22723_XMLParser_A01 extends DefaultHandler {

    private boolean isInUser = false;
    private boolean isInPassword = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("user")) {
            isInUser = true;
        } else if (qName.equalsIgnoreCase("password")) {
            isInPassword = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInUser) {
            String user = new String(ch, start, length);
            // Here we are just printing out the user name.
            // In a real-world application, this should be a secure
            // operation to access and validate the user.
            System.out.println("User: " + user);
            isInUser = false;
        } else if (isInPassword) {
            String password = new String(ch, start, length);
            // Here we are just printing out the password.
            // In a real-world application, this should be a secure
            // operation to access and validate the password.
            System.out.println("Password: " + password);
            isInPassword = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("user")) {
            isInUser = false;
        } else if (qName.equalsIgnoreCase("password")) {
            isInPassword = false;
        }
    }
}