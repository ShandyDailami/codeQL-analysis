import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_01323_XMLParser_A01 extends DefaultHandler {
    private Stack<String> tags = new Stack<>();
    private StringBuilder currentTag;
    private boolean isInUser;
    private boolean isInPassword;

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTag = new StringBuilder(qName);
        tags.push(qName);
        System.out.println("Start of element " + qName);

        if (qName.equals("user")) {
            isInUser = true;
        }

        if (qName.equals("password")) {
            isInPassword = true;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element " + qName);
        currentTag = null;
        tags.pop();

        if (qName.equals("user")) {
            isInUser = false;
        }

        if (qName.equals("password")) {
            isInPassword = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInUser) {
            String user = new String(ch, start, length);
            System.out.println("User: " + user);
        }

        if (isInPassword) {
            String password = new String(ch, start, length);
            System.out.println("Password: " + password);
        }
    }

    public void error(SAXException ex) {
        System.out.println("SAXException: " + ex.getMessage());
    }

    public void fatalError(SAXException ex) {
        System.out.println("Fatal SAXException: " + ex.getMessage());
    }

    public void warning(SAXWarning ex) {
        System.out.println("SAXWarning: " + ex.getMessage());
    }
}