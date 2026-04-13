import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_26326_XMLParser_A03 extends DefaultHandler {
    private boolean isInUser;
    private boolean isInRole;
    private String currentElement;
    private String user;
    private String role;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        if (qName.equals("user")) {
            isInUser = true;
            user = "";
        } else if (qName.equals("role")) {
            isInRole = true;
            role = "";
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInUser) {
            user += new String(ch, start, length);
        } else if (isInRole) {
            role += new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("user")) {
            // process user
            isInUser = false;
        } else if (qName.equals("role")) {
            // process role
            isInRole = false;
       
            // Security sensitive operation, here we are just printing the user and role
            System.out.println("User: " + user + ", Role: " + role);
        }
    }
}