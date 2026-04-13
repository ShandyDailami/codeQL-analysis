import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_32794_XMLParser_A08 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
        elementStack.push(qualifiedName);
        System.out.println("Start of element: " + qualifiedName);
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
        elementStack.pop();
        System.out.println("End of element: " + qualifiedName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String elementContent = new String(ch, start, length).trim();
        if (!elementContent.isEmpty()) {
            String currentElement = elementStack.peek();
            System.out.println("Content of " + currentElement + ": " + elementContent);
        }
    }

    @Override
    public void warning(SAXException e) throws SAXException {
        System.out.println("SAX Warning: " + e.getMessage());
    }

    @Override
    public void error(SAXException e) throws SAXException {
        System.out.println("SAX Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) throws SAXException {
        System.out.println("SAX Fatal Error: " + e.getMessage());
    }
}