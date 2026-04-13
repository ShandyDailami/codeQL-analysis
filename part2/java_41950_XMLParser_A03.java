import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_41950_XMLParser_A03 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startDocument() throws SAXException {
        // empty
    }

    @Override
    public void endDocument() throws SAXException {
        // empty
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Security-sensitive operations
        if (isInjectionAttempt(qName)) {
            throw new SAXException("Injection attempt detected in XML tag: " + qName);
        }
        elementStack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // empty
    }

    private boolean isInjectionAttempt(String elementName) {
        // Assuming injection attempts are when the element name contains specific words or sequences
        String[] injectionWords = {"delete", "drop", "insert", "update", "select"};
        for (String word : injectionWords) {
            if (elementName.toLowerCase().contains(word)) {
                return true;
            }
        }
        return false;
    }

    public Stack<String> getElementStack() {
        return elementStack;
    }
}