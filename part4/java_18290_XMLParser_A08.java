import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_18290_XMLParser_A08 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private String currentElement = "";
    private boolean integrityFailure = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        currentElement = elementStack.isEmpty() ? "" : elementStack.peek();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementStack.peek().equals("A08_IntegrityFailure")) {
            integrityFailure = true;
        }
        String content = new String(ch, start, length);
        if (currentElement.equals("A08_IntegrityFailure")) {
            integrityFailure = true;
        }
    }

    public boolean isIntegrityFailure() {
        return integrityFailure;
    }

    public void reset() {
        integrityFailure = false;
    }
}