import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.Stack;

public class java_23188_XMLParser_A01 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private StringBuffer buffer = new StringBuffer();

    public void startDocument() {
        System.out.println("Parsing started");
    }

    public void endDocument() {
        System.out.println("Parsing finished");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        elementStack.push(qName);
        buffer.setLength(0);
    }

    public void endElement(String uri, String localName, String qName) {
        elementStack.pop();
        if (elementStack.isEmpty()) {
            processElement(qName, buffer.toString());
        } else {
            buffer.append(" - ");
            buffer.append(qName);
        }
    }

    public void characters(char[] ch, int start, int length) {
        buffer.append(ch, start, length);
    }

    private void processElement(String name, String content) {
        System.out.println("Processing element: " + name + ", Content: " + content);
    }

    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal error: " + e.getMessage());
    }

    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }
}