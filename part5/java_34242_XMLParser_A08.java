import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_34242_XMLParser_A08 extends DefaultHandler {
    private static final String ELEMENT_TAG = "element";
    private static final String ATTRIBUTE_TAG = "attribute";

    private Stack<String> stack = new Stack<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stack.push(qName);
        System.out.println("Start element: " + qName);
        handleAttributes(attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        stack.pop();
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String elementContent = new String(ch, start, length);
        System.out.println("Element content: " + elementContent);
    }

    private void handleAttributes(Attributes attributes) {
        if (attributes != null) {
            System.out.println("Attributes:");
            for (int i = 0; i < attributes.getLength(); i++) {
                String attributeName = attributes.getQName(i);
                String attributeValue = attributes.getValue(i);
                System.out.println("Attribute: " + attributeName + " = " + attributeValue);
            }
        }
    }
}