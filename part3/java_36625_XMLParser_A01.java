import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_36625_XMLParser_A01 extends DefaultHandler {
    private Stack<String> securityStack = new Stack<>();
    private boolean isSecurityElement = false;
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Start of an XML element, push the current element onto the stack
        securityStack.push(qName);
        currentElement = qName;
        isSecurityElement = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // End of an XML element
        securityStack.pop();
        currentElement = "";
        isSecurityElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Process character data, this is where the security checks are performed
        if (isSecurityElement) {
            String elementContent = new String(ch, start, length);
            // Perform security checks on the content of the current element
            // For example:
            if (elementContent.contains("<")) {
                System.out.println("Warning: Security check failed for element: " + currentElement);
            }
        }
    }
}