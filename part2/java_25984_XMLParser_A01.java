import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_25984_XMLParser_A01 extends DefaultHandler {
    private boolean isPassword = false;
    private boolean isAdminPassword = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("password")) {
            isPassword = true;
        } else if (qName.equalsIgnoreCase("admin_password")) {
            isAdminPassword = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("password")) {
            isPassword = false;
        } else if (qName.equalsIgnoreCase("admin_password")) {
            isAdminPassword = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isPassword) {
            System.out.println("Password found: " + new String(ch, start, length));
        } else if (isAdminPassword) {
            System.out.println("Admin password found: " + new String(ch, start, length));
        }
    }
}