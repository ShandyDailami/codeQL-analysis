import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_39599_XMLParser_A01 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private StringBuilder currentElement = new StringBuilder();
    private StringBuilder currentValue = new StringBuilder();
    private boolean accessControl = false;

    @Override
    public void startDocument() throws SAXException {
        // Start the parser
        System.out.println("Parsing started!");
    }

    @Override
    public void endDocument() throws SAXException {
        // End the parser
        System.out.println("Parsing ended!");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Push the current element onto the stack
        elementStack.push(qName);

        // Initialize the current element
        currentElement.setLength(0);
        currentElement.append(qName);

        // Check if the element is related to access control
        if (qName.equals("A01_BrokenAccessControl")) {
            accessControl = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Pop the current element from the stack
        elementStack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Append the current character data
        currentValue.append(ch, start, length);
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        // Print a warning message
        System.out.println("WARNING: " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        // Print an error message
        System.out.println("ERROR: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        // Print a fatal error message
        System.out.println("FATAL ERROR: " + e.getMessage());
    }
}