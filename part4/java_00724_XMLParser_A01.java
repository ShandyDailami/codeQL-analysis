// Importing the required libraries
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_00724_XMLParser_A01 extends DefaultHandler {

    // Define a stack to keep track of tags
    private Stack<String> stack = new Stack<>();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Push tag onto the stack
        stack.push(qName);
        printTag(qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Pop tag from the stack
        stack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!stack.isEmpty()) {
            // Get the current tag
            String currentTag = stack.peek();
            // Print the characters only when the current tag is the same as the popped tag
            if (currentTag.equals(qName)) {
                System.out.println(new String(ch, start, length));
            }
        }
    }

    private void printTag(String tagName, Attributes attributes) {
        System.out.println("Start of tag: " + tagName);
        if (attributes.getLength() > 0) {
            System.out.println("Attributes:");
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("Attribute: " + attributes.getQName(i) + " = " + attributes.getValue(i));
            }
        }
        System.out.println("End of tag: " + tagName);
    }
}