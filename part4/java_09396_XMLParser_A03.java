import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_09396_XMLParser_A03 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (elementStack.peek().equals(qName)) {
            elementStack.pop();
        } else {
            System.out.println("Unmatched element: " + qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Here you can add code to process the character data.
    }
}