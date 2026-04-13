import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import java.util.Stack;

public class java_41736_XMLParser_A08 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!elementStack.isEmpty()) {
            String topElement = elementStack.pop();
            if (topElement.equals(qName)) {
                // End of expected element, check integrity
                verifyIntegrity();
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // This method is never called in this case, but is required by the SAX API
    }

    @Override
    public void saxError(SAXParseException e) {
        System.out.println("SAXParseException: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) {
        System.out.println("FatalError: " + e.getMessage());
    }

    private void verifyIntegrity() {
        // Verify the integrity of the XML document
        // This is a placeholder and does nothing in this example
    }
}