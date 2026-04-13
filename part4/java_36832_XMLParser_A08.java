import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_36832_XMLParser_A08 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private StringBuilder currentElementContent = new StringBuilder();
    private boolean isInElement = false;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        currentElementContent.setLength(0);
        isInElement = true;
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        currentElementContent.append(" (content: " + currentElementContent.toString() + ") ");
        System.out.println("End of element: " + qName + " Content: " + currentElementContent);
        isInElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            currentElementContent.append(new String(ch, start, length));
        }
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