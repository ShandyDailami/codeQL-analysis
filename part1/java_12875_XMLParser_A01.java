import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_12875_XMLParser_A01 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();
    private String lastElement = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        lastElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isAllowedElement(qName)) {
            elementStack.pop();
            lastElement = null;
        } else {
            System.out.println("Access to element " + qName + " is denied.");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement != null && isAllowedElement(lastElement)) {
            System.out.println(new String(ch, start, length));
        }
    }

    private boolean isAllowedElement(String element) {
        // This is a simple example. In a real-world application, you would probably have a list of allowed elements.
        return element.equals("element1") || element.equals("element2");
    }
}