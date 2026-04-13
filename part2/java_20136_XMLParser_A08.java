import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_20136_XMLParser_A08 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private StringBuilder data = new StringBuilder();
    private String currentElement;
    private StringBuilder integrityFailureData;

    public java_20136_XMLParser_A08() {
        this.integrityFailureData = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stack.push(qName);
        data.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(currentElement)) {
            checkIntegrity(stack.pop());
        }
        stack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(ch, start, length);
    }

    private void checkIntegrity(String element) {
        if (element.equals("A08_IntegrityFailure")) {
            integrityFailureData.append(element).append(": ").append(data.toString());
        }
    }

    public StringBuilder getIntegrityFailureData() {
        return integrityFailureData;
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        currentElement = uri;
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        currentElement = null;
    }
}