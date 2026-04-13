import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_10263_XMLParser_A07 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private boolean isInUsername = false;
    private boolean isInPassword = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stack.push(qName);
        if (qName.equals("username")) {
            isInUsername = true;
        } else if (qName.equals("password")) {
            isInPassword = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        stack.pop();
        if (qName.equals("username")) {
            isInUsername = false;
        } else if (qName.equals("password")) {
            isInPassword = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        if (isInUsername) {
            // Security sensitive operation: check if it's the most sensitive operation in the context
            // if (content.equals("your_sensitive_username")) {
            //     throw new AuthFailureException("Username is sensitive!");
            // }
        } else if (isInPassword) {
            // Security sensitive operation: check if it's the most sensitive operation in the context
            // if (content.equals("your_sensitive_password")) {
            //     throw new AuthFailureException("Password is sensitive!");
            // }
        }
    }
}