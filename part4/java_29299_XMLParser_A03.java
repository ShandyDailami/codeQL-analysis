import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_29299_XMLParser_A03 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        elementStack.push(qName);
        buffer.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (localName.equals(elementStack.peek())) {
            elementStack.pop();
            // Here you can add the security sensitive operation like injection.
            // For example, a check if the user input is a valid email, or a check for SQL injection.

        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        buffer.append(ch, start, length);
    }

    @Override
    public void warning(SAXException e) {
        System.out.println("SAX warning: " + e.getMessage());
    }

    @Override
    public void error(SAXException e) {
        System.out.println("SAX error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) {
        System.out.println("SAX fatal error: " + e.getMessage());
    }
}