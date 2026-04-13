import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_00290_XMLParser_A07 extends DefaultHandler {
    private Stack<String> elementStack;
    private String currentElement;

    public java_00290_XMLParser_A07() {
        elementStack = new Stack<>();
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
        elementStack.push(qName);
        currentElement = qName;
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = elementStack.pop();
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals("AuthFailure")) { // Check if the current element is 'AuthFailure'
            System.out.println("AuthFailure: " + new String(ch, start, length));
        }
    }
}