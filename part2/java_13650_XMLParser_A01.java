import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_13650_XMLParser_A01 extends DefaultHandler {

    private static final String ROOT = "ROOT";
    private static final String USER = "USER";
    private static final String PASSWORD = "PASSWORD";

    private String currentElement;
    private Stack<String> elementStack;
    private boolean rootFound;
    private boolean userFound;
    private boolean passwordFound;

    public java_13650_XMLParser_A01() {
        elementStack = new Stack<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);

        switch (qName) {
            case ROOT:
                rootFound = true;
                break;
            case USER:
                userFound = true;
                break;
            case PASSWORD:
                passwordFound = true;
                break;
        }

        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();

        if (currentElement.equals(qName)) {
            switch (qName) {
                case ROOT:
                    if (!rootFound) {
                        throw new SAXException("Broken access control: Root element not found");
                    }
                    break;
                case USER:
                    if (!userFound) {
                        throw new SAXException("Broken access control: User element not found");
                    }
                    break;
                case PASSWORD:
                    if (!passwordFound) {
                        throw new SAXException("Broken access control: Password element not found");
                    }
                    break;
            }
        } else {
            throw new SAXException("Broken access control: Unexpected element found");
        }

        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement != null && rootFound && userFound && passwordFound) {
            String value = new String(ch, start, length);
            // Handle sensitive data here, e.g., store in a secure manner or log it
            System.out.println("Sensitive data: " + value);
        }
    }
}