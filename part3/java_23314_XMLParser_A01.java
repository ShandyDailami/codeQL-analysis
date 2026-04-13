import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_23314_XMLParser_A01 extends DefaultHandler {
    private static final String ROOT = "root";
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private Stack<String> stack = new Stack<>();
    private StringBuffer buffer = new StringBuffer();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.setLength(0); // clear buffer
        stack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String elementName = qName;
        stack.pop();

        if (ROOT.equals(elementName)) {
            // Security sensitive operation: Access control
            String password = attributes.getValue(PASSWORD);
            if (password == null || password.length() < 8) {
                System.out.println("Broken Access Control: Password length is less than 8!");
            }
        } else if (USER.equals(elementName)) {
            // Security sensitive operation: Access control
            String password = attributes.getValue(PASSWORD);
            if (password == null || password.isEmpty()) {
                System.out.println("Broken Access Control: Password is null or empty!");
            }
        } else {
            // Non-security sensitive operation
            System.out.println("Non-security sensitive operation: " + elementName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (stack.peek().equals(USER) || stack.peek().equals(PASSWORD)) {
            buffer.append(ch, start, length);
        }
    }
}