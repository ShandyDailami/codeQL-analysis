import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_38023_XMLParser_A01 extends DefaultHandler {

    private boolean accessControlEnabled = false;
    private boolean passwordProtected = false;

    public boolean isAccessControlEnabled() {
        return accessControlEnabled;
    }

    public boolean isPasswordProtected() {
        return passwordProtected;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("configuration")) {
            accessControlEnabled = true;
            passwordProtected = attributes.getValue("passwordProtected");
        }
    }

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            SecurityBreachHandler securityBreachHandler = new SecurityBreachHandler();
            saxParser.parse(xmlFile, securityBreachHandler);

            if (securityBreachHandler.isAccessControlEnabled() && securityBreachHandler.isPasswordProtected()) {
                System.out.println("Access control and password protection detected in the XML file!");
            } else {
                System.out.println("Access control or password protection not detected in the XML file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}