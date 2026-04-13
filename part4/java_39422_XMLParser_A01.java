import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.Stack;

public class java_39422_XMLParser_A01 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    public java_39422_XMLParser_A01() {
        super();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        // Disallow access to elements that should not be in
        if (!"element".equals(localName)) {
            throw new SAXException("Attempt to access elements outside allowed namespace: " + localName);
        }
        elementStack.push(localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // If the popped element was not the end element of the current element, then abort.
        if (!elementStack.pop().equals(localName)) {
            throw new SAXException("End element doesn't match start element: " + localName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // This method should not be called in this case because we're not interested in character data.
        throw new SAXException("Attempt to read character data outside allowed namespace: " + new String(ch, start, length));
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        // Throw an exception that indicates that an error occurred.
        throw new SAXException("SAXParseException: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        // Throw an exception that indicates that an fatal error occurred.
        throw new SAXException("SAXParseException: " + e.getMessage());
   
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        // Throw an exception that indicates that a warning occurred.
        throw new SAXException("SAXParseException: " + e.getMessage());
    }
}