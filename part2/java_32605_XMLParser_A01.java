import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_32605_XMLParser_A01 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    private StringBuilder buffer = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        buffer.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!elementStack.isEmpty()) {
            String top = elementStack.pop();
            if (top.equals("element")) {
                // Security sensitive operation: Checking if the XML element is named 'element'
                // If not, print a warning message and reset the buffer
                if (!localName.equals("element")) {
                    System.out.println("Warning: Expected 'element', but got '" + localName + "'");
                    buffer.setLength(0);
                } else {
                    // Security sensitive operation: Checking if the buffer contains sensitive information
                    // If it does, print a warning message and reset the buffer
                    if (buffer.toString().contains("sensitive info")) {
                        System.out.println("Warning: Sensitive information found in XML element");
                        buffer.setLength(0);
                    }
                }
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }
}