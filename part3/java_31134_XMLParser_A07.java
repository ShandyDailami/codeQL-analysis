import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_31134_XMLParser_A07 extends DefaultHandler {

    private boolean isUsername = false;
    private boolean isPassword = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("username")) {
            isUsername = true;
        } else if (qName.equalsIgnoreCase("password")) {
            isPassword = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isUsername) {
            String username = new String(ch, start, length);
            // perform security sensitive operation with username here
            isUsername = false;
        } else if (isPassword) {
            String password = new String(ch, start, length);
            // perform security sensitive operation with password here
            isPassword = false;
        }
    }
}