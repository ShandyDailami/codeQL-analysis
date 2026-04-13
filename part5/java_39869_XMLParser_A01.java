import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_39869_XMLParser_A01 extends DefaultHandler {
    private List<String> securityActions = new ArrayList<>();

    @Override
    public void startDocument() throws SAXException {
        // No Action Required.
    }

    @Override
    public void endDocument() throws SAXException {
        // No Action Required.
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Check for Security Actions
        if (localName.equals("action")) {
            String action = attributes.getValue("name");
            // Adding security sensitive operation here
            if ("DENY".equals(action)) {
                securityActions.add("Broken Access Control - DENY");
            } else if ("ALLOW".equals(action)) {
                securityActions.add("Broken Access Control - ALLOW");
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // No Action Required.
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // No Action Required.
    }

    public List<String> getSecurityActions() {
        return securityActions;
    }
}