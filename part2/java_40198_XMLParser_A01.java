import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_40198_XMLParser_A01 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private StringBuilder data = new StringBuilder();
    private boolean isInElement = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (stack.isEmpty()) {
            System.out.println("Access granted for " + qName);
        } else {
            if (stack.peek().equals(qName)) {
                System.out.println("Access granted for " + qName);
            } else {
                System.out.println("Access denied for " + qName);
            }
        }
        data.setLength(0);
        isInElement = true;
        stack.push(qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        data.append(qName);
        isInElement = false;
        stack.pop();
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            data.append(ch, start, length);
        }
    }
}