import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_32269_XMLParser_A03 extends DefaultHandler {

    private boolean bUsername = false;
    private boolean bPassword = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("username")) {
            bUsername = true;
        } else if (qName.equals("password")) {
            bPassword = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bUsername) {
            String username = new String(ch, start, length);
            System.out.println("Username: " + username);
            bUsername = false;
        } else if (bPassword) {
            String password = new String(ch, start, length);
            System.out.println("Password: " + password);
            bPassword = false;
        }
    }
}