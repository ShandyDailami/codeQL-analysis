import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_13541_XMLParser_A08 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();
    private StringBuilder currentElementContent = new StringBuilder();
    private StringBuilder currentElementAttributeValue = new StringBuilder();
    private StringBuilder currentElementAttributeName = new StringBuilder();
    private boolean isInElement = false;
    private boolean isInAttribute = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        currentElementContent.setLength(0);
        isInElement = true;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            currentElementContent.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("element")) {
            // Process element here
            System.out.println("Element: " + elementStack.pop());
            System.out.println("Content: " + currentElementContent.toString());
            System.out.println("Attributes: " + currentElementAttributeName + ", " + currentElementAttributeValue);
        } else {
            if (isInElement) {
                // Process element here
                System.out.println("End Element: " + qName);
                isInElement = false;
            }
        }
    }

    @Override
    public void startAttribute(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (isInElement) {
            currentElementAttributeName.setLength(0);
            currentElementAttributeName.append(localName);
            isInAttribute = true;
        }
    }

    @Override
    public void endAttribute(String uri, String localName, String qName) throws SAXException {
        if (isInAttribute) {
            currentElementAttributeValue.setLength(0);
            currentElementAttributeValue.append(qName);
            isInAttribute = false;
        }
    }
}