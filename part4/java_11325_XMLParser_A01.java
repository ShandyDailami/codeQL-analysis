import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_11325_XMLParser_A01 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();

    public java_11325_XMLParser_A01() {
        super();
    }

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
        stack.push(qName);
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        stack.pop();
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        if (!stack.isEmpty()) {
            System.out.println("Element content: " + content + " -> inside " + stack.peek());
        } else {
            System.out.println("Element content: " + content + " -> root");
        }
    }

    @Override
    public void fatalError(String error) throws SAXException {
        System.out.println("Fatal error: " + error);
    }
}