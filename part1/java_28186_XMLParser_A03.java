import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_28186_XMLParser_A03 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();
    private boolean isInsideElement = false;
    private StringBuilder currentElementContent = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        isInsideElement = true;
        currentElementContent.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isInsecureOperation(qName)) {
            System.out.println("Suspicious operation found!");
        }

        elementStack.pop();
        isInsideElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInsideElement) {
            currentElementContent.append(ch, start, length);
        }
    }

    private boolean isInsecureOperation(String elementName) {
        // Adding a list of insecure operations
        return elementName.equals("insecureElement1") || elementName.equals("insecureElement2");
    }
}