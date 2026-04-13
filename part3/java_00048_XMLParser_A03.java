import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_00048_XMLParser_A03 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String element = elementStack.peek();
        if (element.equals("book")) {
            // Inside book element, handle SAX events
        } else if (element.equals("title")) {
            // Inside title element, handle SAX events
        } else if (element.equals("author")) {
            // Inside author element, handle SAX events
        }
    }
}