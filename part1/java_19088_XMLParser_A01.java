import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_19088_XMLParser_A01 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private StringBuilder text = new StringBuilder();
    private boolean isInElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        text.setLength(0);
        isInElement = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isValidElement(qName)) {
            System.out.println(qName + ": " + text.toString().trim());
        } else {
            System.out.println("Access to " + qName + " is restricted.");
        }
        elementStack.pop();
        text.setLength(0);
        isInElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            text.append(ch, start, length);
        }
    }

    private boolean isValidElement(String element) {
        // Implement your security logic here.
        // For the purpose of this example, we're just checking if the element is "access"
        return "access".equals(element);
    }
}