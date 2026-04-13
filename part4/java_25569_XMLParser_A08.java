import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_25569_XMLParser_A08 extends DefaultHandler {
    private static final String TARGET = "target";
    private static final String DATA = "data";
    private Stack<String> stack = new Stack<>();

    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start of element: " + qName);
        stack.push(qName);
        // Check if 'target' and 'data' are attributes
        if (qName.equalsIgnoreCase(TARGET) || qName.equalsIgnoreCase(DATA)) {
            String attributeName = attributes.getValue(0).toLowerCase();
            // Handle the attribute:
            if (attributeName.equals(TARGET)) {
                System.out.println("TARGET attribute found!");
            } else if (attributeName.equals(DATA)) {
                System.out.println("DATA attribute found!");
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of element: " + qName);
        stack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String content = new String(ch, start, length).trim();
        if (!content.isEmpty()) {
            String currentElement = stack.empty() ? "Root" : stack.peek();
            System.out.println(currentElement + ": " + content);
        }
    }

    @Override
    public void fatalError(SAXException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    @Override
    public void error(SAXException e) {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void warning(SAXException e) {
        System.out.println("Warning: " + e.getMessage());
    }
}