import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_11706_XMLParser_A01 extends DefaultHandler {

    private static final String ROOT = "security";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    private Stack<String> stack = new Stack<>();
    private StringBuilder buffer = new StringBuilder();

    private String currentUser;
    private String currentPassword;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Starting document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Ending document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Starting element: " + qName);

        // Only process <security> elements
        if (ROOT.equals(qName)) {
            return;
        }

        // Only process <user> elements
        if (USER.equals(qName)) {
            currentUser = attributes.getValue(0);
        } else if (PASSWORD.equals(qName)) {
            currentPassword = attributes.getValue(0);
        }

        // Push the current element onto the stack
        stack.push(qName);

        // Print the current element and its attributes
        System.out.print("Element: " + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.print(" " + attributes.getQName(i) + "=" + attributes.getValue(i));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Ending element: " + qName);

        // Pop the current element from the stack
        stack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void warning(SAXException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void error(SAXException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }
}