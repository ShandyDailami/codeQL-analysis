import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_27383_XMLParser_A03 extends DefaultHandler {
    private Stack<String> q = new Stack<>();
    private StringBuilder currentValue = new StringBuilder();
    private String namespaceURI;
    private String localName;

    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        this.namespaceURI = namespaceURI;
        this.localName = localName;

        if (isSecuritySensitiveOperation()) {
            System.out.println("Injection attempt detected!");
        }

        System.out.println("Start of Element: " + localName);
        q.push(localName);
        currentValue.setLength(0);
    }

    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        System.out.println("End of Element: " + localName);
        q.pop();
        currentValue.setLength(0);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue.append(ch, start, length);
    }

    public void error(SAXException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
    }

    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    public void warning(SAXException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }

    private boolean isSecuritySensitiveOperation() {
        // Implement the security sensitive operation here
        return false;
    }
}