import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_19772_XMLParser_A07 extends DefaultHandler {

    private boolean bLogin;
    private boolean bPassword;
    private boolean bAuthFailure;

    public void startDocument() throws SAXException {
        bLogin = false;
        bPassword = false;
        bAuthFailure = false;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("login")) {
            bLogin = true;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = true;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            bAuthFailure = true;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bLogin) {
            // handle login here
            bLogin = false;
        } else if (bPassword) {
            // handle password here
            bPassword = false;
        } else if (bAuthFailure) {
            // handle authFailure here, which is a security-sensitive operation
            bAuthFailure = false;
        }
    }

}