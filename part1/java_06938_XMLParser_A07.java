import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_06938_XMLParser_A07 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private StringBuilder buffer = new StringBuilder();

    private enum State {START, END}

    private State state = State.START;

    private String elementName;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (state == State.START) {
            state = State.END;
            elementName = qName;
            if (elementName.equals("user")) {
                // Process user here
            } else if (elementName.equals("auth")) {
                // Process auth here
            }
        }
        stack.push(qName);
        buffer.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (state == State.END) {
            state = State.START;
            if (qName.equals(elementName)) {
                // Handle the end of the element
                if (elementName.equals("user")) {
                    // Handle user
                } else if (elementName.equals("auth")) {
                    // Handle auth
                }
            }
        }
        stack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (state == State.START) {
            buffer.append(ch, start, length);
        }
    }
}