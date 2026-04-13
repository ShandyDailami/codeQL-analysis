import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_20295_XMLParser_A01 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private StringBuffer buffer = new StringBuffer();
    private boolean bTag = false;
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        buffer.setLength(0);
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        if (currentElement.equals(qName)) {
            if (bTag) {
                // Handle broken access control
                String content = buffer.toString();
                // Do some security sensitive operations with content
            }
            buffer.setLength(0);
        } else {
            buffer.append("<");
            buffer.append(currentElement);
            buffer.append(">");
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }
}