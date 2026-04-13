import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_18016_XMLParser_A03 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Add your security-sensitive operations here
        stack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Add your security-sensitive operations here
        if (qName.equals(stack.peek())) {
            stack.pop();
        }
    }
}