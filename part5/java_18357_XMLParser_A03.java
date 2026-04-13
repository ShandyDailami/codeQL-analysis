import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_18357_XMLParser_A03 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Starting XML document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Ending XML document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Starting element: " + qName);
        elementStack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Ending element: " + qName);
        elementStack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        handleContent(content);
    }

    private void handleContent(String content) {
        // This method is used to handle security-sensitive operations.
        // It's left as an empty method for you to implement the logic.
        // For example, you can sanitize the content, check if it contains any
        // injection attacks, etc.
    }
}