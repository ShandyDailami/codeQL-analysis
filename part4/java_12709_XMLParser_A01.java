import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_12709_XMLParser_A01 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();
    private boolean isInSecurityElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(isSecurityElement(qName)) {
            isInSecurityElement = true;
            elementStack.push(qName);
        } else if(isInSecurityElement && isAccessControlElement(qName)) {
            throw new SAXException("Access control violation: " + qName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(isInSecurityElement) {
            elementStack.pop();
            if(elementStack.isEmpty()) {
                isInSecurityElement = false;
            }
        }
    }

    private boolean isSecurityElement(String qName) {
        return "security".equals(qName);
    }

    private boolean isAccessControlElement(String qName) {
        return "allow".equals(qName) || "deny".equals(qName);
    }
}