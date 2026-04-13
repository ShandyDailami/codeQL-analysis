import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_25312_XMLParser_A01 extends DefaultHandler {

    private Stack<String> elementStack;
    private StringBuilder text;

    public java_25312_XMLParser_A01() {
        elementStack = new Stack<>();
        text = new StringBuilder();
    }

    public String getText() {
        return text.toString();
    }

    @Override
    public void startDocument() {
        System.out.println("Start of XML document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of XML document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start of element: " + qName);
        elementStack.push(qName);
        text.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of element: " + qName);
        elementStack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Text inside element: " + new String(ch, start, length));
        text.append(new String(ch, start, length));
    }

    @Override
    public void warning(SAXException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void error(SAXException e) {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) {
        System.out.println("Fatal error: " + e.getMessage());
    }
}