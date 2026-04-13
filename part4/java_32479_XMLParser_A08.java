import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_32479_XMLParser_A08 extends DefaultHandler {

    private static final String ELEMENT = "element";
    private static final String ATTRIBUTE = "attribute";
    private static final String DEFAULT_NAMESPACE = "default";

    private Stack<String> stack = new Stack<>();
    private String currentElement = "";
    private String currentAttributeName = "";
    private String currentAttributeValue = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stack.push(qName);

        if (!attributes.haslocalName(ATTRIBUTE)) {
            currentElement = qName;
        } else {
            currentAttributeName = attributes.getValue(ATTRIBUTE);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(currentElement)) {
            if (currentAttributeName != null && !currentAttributeName.isEmpty()) {
                // Handle the element and attribute
                System.out.println("Element: " + currentElement);
                System.out.println("Attribute: " + currentAttributeName + " = " + currentAttributeValue);
            } else {
                // Handle the element
                System.out.println("Element: " + currentElement);
            }

            currentElement = "";
            currentAttributeName = "";
            currentAttributeValue = "";
        } else {
            stack.pop();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!stack.isEmpty()) {
            currentAttributeValue = new String(ch, start, length);
        }
    }
}