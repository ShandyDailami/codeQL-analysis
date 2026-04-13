import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_21643_XMLParser_A08 extends DefaultHandler {

    private StringBuilder currentElementData;
    private List<String> securityIssues;

    public java_21643_XMLParser_A08() {
        this.securityIssues = new ArrayList<>();
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.currentElementData = new StringBuilder();
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Check for security issues
        if (this.currentElementData.toString().contains("password") ||
                this.currentElementData.toString().contains("login") ||
                this.currentElementData.toString().contains("secret")) {
            this.securityIssues.add("Security issue detected in element: " + localName);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        this.currentElementData.append(ch, start, length);
    }

    public List<String> getSecurityIssues() {
        return this.securityIssues;
    }
}