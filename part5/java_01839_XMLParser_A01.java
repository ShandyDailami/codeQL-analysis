import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_01839_XMLParser_A01 extends DefaultHandler {
    private boolean userNodeFound;
    private boolean passwordNodeFound;
    private boolean roleNodeFound;

    private static final String USER_NODE = "user";
    private static final String PASSWORD_NODE = "password";
    private static final String ROLE_NODE = "role";

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        SecurityChecker handler = new SecurityChecker();
        parser.parse(new File("src/sample.xml"), handler);
    }

    @Override
    public void startDocument() {
        userNodeFound = false;
        passwordNodeFound = false;
        roleNodeFound = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase(USER_NODE)) {
            userNodeFound = true;
        } else if (qName.equalsIgnoreCase(PASSWORD_NODE)) {
            passwordNodeFound = true;
        } else if (qName.equalsIgnoreCase(ROLE_NODE)) {
            roleNodeFound = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase(USER_NODE) && !userNodeFound) {
            System.out.println("Security warning: user node not found in the XML file!");
        }

        if (qName.equalsIgnoreCase(PASSWORD_NODE) && !passwordNodeFound) {
            System.out.println("Security warning: password node not found in the XML file!");
        }

        if (qName.equalsIgnoreCase(ROLE_NODE) && !roleNodeFound) {
            System.out.println("Security warning: role node not found in the XML file!");
        }
    }
}