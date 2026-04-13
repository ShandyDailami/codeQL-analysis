import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_10619_XMLParser_A01 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private boolean isInTag = false;
    private String currentTag = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        isInTag = true;
        currentTag = qName;
        elementStack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        currentTag = elementStack.isEmpty() ? "" : elementStack.peek();
        isInTag = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInTag && currentTag.equals("brokenAccess")) {
            // handle the 'brokenAccess' element, but not any other element
            System.out.println("Access to security-sensitive operation detected.");
        }
    }
}