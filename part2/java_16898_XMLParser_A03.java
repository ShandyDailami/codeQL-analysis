import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_16898_XMLParser_A03 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private String currentElement = null;
    private boolean isInElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Avoid entering inside the element if it's a security-sensitive operation
        if (localName.equals("input") || localName.equals("script") || localName.equals("style")) {
            return;
        }
        elementStack.push(localName);
        currentElement = localName;
        isInElement = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        currentElement = elementStack.isEmpty() ? null : elementStack.peek();
        isInElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement && currentElement != null) {
            // Do some security-sensitive operation, for example: print the content
            System.out.println(new String(ch, start, length));
        }
    }
}