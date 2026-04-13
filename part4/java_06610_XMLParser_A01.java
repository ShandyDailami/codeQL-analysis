import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.Stack;

public class java_06610_XMLParser_A01 extends DefaultHandler {

    // A stack to keep track of XML tag hierarchy
    private Stack<String> stack = new Stack<>();

    // Sensitive operations related to BrokenAccessControl
    private boolean isAccessControlBroken = false;

    // Method to handle XML start elements
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXParseException {

        // Check for access control breach
        if (isAccessControlBroken) {
            throw new SAXParseException("Access control breach detected");
        }

        // Push the tag onto the stack
        stack.push(qName);
    }

    // Method to handle XML end elements
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXParseException {

        // Check for access control breach
        if (isAccessControlBroken) {
            throw new SAXParseException("Access control breach detected");
        }

        // Pop the top element from the stack
        if (!stack.pop().equals(qName)) {
            throw new SAXParseException("Unexpected end element");
        }
    }

    // Method to handle parsing errors
    @Override
    public void SAXParseException(SAXParseException e) {
        throw e;
    }

    // Method to check access control breach
    public void setAccessControlBroken(boolean broken) {
        isAccessControlBroken = broken;
    }
}