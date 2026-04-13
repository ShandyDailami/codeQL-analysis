import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_13129_XMLParser_A01 extends DefaultHandler {

    private boolean isInSecurityElement = false;
    private boolean isInUsernameElement = false;
    private boolean isInPasswordElement = false;
    private boolean isInRoleElement = false;

    private String username;
    private String password;
    private String role;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("Security")) {
            isInSecurityElement = true;
        } else if (qName.equals("Username")) {
            isInUsernameElement = true;
        } else if (qName.equals("Password")) {
            isInPasswordElement = true;
        } else if (qName.equals("Role")) {
            isInRoleElement = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("Security")) {
            isInSecurityElement = false;
        } else if (qName.equals("Username")) {
            isInUsernameElement = false;
        } else if (qName.equals("Password")) {
            isInPasswordElement = false;
        } else if (qName.equals("Role")) {
            isInRoleElement = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInUsernameElement) {
            username = new String(ch, start, length);
        } else if (isInPasswordElement) {
            password = new String(ch, start, length);
        } else if (isInRoleElement) {
            role = new String(ch, start, length);
        }
    }

    public void parse(String xml) throws SAXException {
        org.xml.sax.SAXParserFactory spf = org.xml.sax.SAXParserFactory.newInstance();
        org.xml.sax.SAXParser sp = spf.newSAXParser(null);
        sp.setContentHandler(this);
        sp.parse(xml);
    }
}