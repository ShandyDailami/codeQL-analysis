import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_07175_XMLParser_A01 extends DefaultHandler {

    private String lastElement;
    private boolean isSecurityElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("security".equals(qName)) {
            isSecurityElement = true;
        } else {
            isSecurityElement = false;
        }

        lastElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isSecurityElement) {
            if ("username".equals(qName) && "user".equals(lastElement)) {
                System.out.println("Security violation: A01_BrokenAccessControl: Access to a sensitive data was restricted.");
            } else if ("password".equals(qName) && ("user".equals(lastElement) || "admin".equals(lastElement))) {
                System.out.println("Security violation: A01_BrokenAccessControl: Access to a sensitive data was restricted.");
            }
            isSecurityElement = false;
        }

        lastElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isSecurityElement) {
            String value = new String(ch, start, length);
            System.out.println("Security violation: A01_BrokenAccessControl: Sensitive data: " + value);
        }
    }
}