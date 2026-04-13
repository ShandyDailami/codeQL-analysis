import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_02153_XMLParser_A08 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private boolean isInSecurityElement = false;
    private StringBuilder text = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        isInSecurityElement = true;
        text.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        if (isInSecurityElement && "a08_integrity_failure".equals(qName)) {
            System.out.println("Security-sensitive operation related to A08_IntegrityFailure detected: " + text.toString());
        }
        isInSecurityElement = false;
        text.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInSecurityElement) {
            text.append(ch, start, length);
        }
    }
}