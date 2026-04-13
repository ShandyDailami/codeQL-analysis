import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_24504_XMLParser_A03 extends DefaultHandler {
    private String currentElement;
    private List<String> securitySensitiveOperations;

    public java_24504_XMLParser_A03() {
        this.securitySensitiveOperations = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.currentElement = "";

        if (qName.equals("operation")) {
            String operation = attributes.getValue("name");
            // Some security-sensitive operations like injection attack...
            if (operation.contains("injection")) {
                securitySensitiveOperations.add(operation);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals("operation")) {
            String operation = new String(ch, start, length);
            // Some security-sensitive operations like injection attack...
            if (operation.contains("injection")) {
                securitySensitiveOperations.add(operation);
            }
        }
    }

    public List<String> getSecuritySensitiveOperations() {
        return securitySensitiveOperations;
    }
}