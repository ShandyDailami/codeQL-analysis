import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.security.InvalidParameterException;
import java.util.Stack;

public class java_26501_XMLParser_A03 extends DefaultHandler {

    private StringBuilder content = new StringBuilder();
    private Stack<String> elementStack = new Stack<>();

    private boolean parsingElement = false;
    private String currentElement = "";

    private boolean parsingSecurity = false;
    private String currentSecurity = "";

    public String getContent() {
        return content.toString();
    }

    @Override
    public void startDocument() throws SAXException {
        parsingSecurity = true;
    }

    @Override
    public void endDocument() throws SAXException {
        if (!elementStack.isEmpty()) {
            throw new InvalidParameterException("Not all elements have been closed");
        }
        parsingSecurity = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (parsingSecurity) {
            throw new InvalidParameterException("Security elements can't be nested in the XML");
        }
        parsingElement = true;
        currentElement = qName;
        elementStack.push(currentElement);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (parsingElement) {
            if (!currentElement.equals(qName)) {
                throw new InvalidParameterException("Wrong element closed");
            }
            content.append(elementStack.pop());
        }
        parsingElement = false;
        currentElement = "";
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        if (parsingElement) {
            content.append(new String(chars, start, length));
        }
    }

}