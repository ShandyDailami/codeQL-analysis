import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_13519_XMLParser_A03 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (!stack.isEmpty()) {
            stack.peek().append(">");
            buffer.append("<");
            stack.push(buffer.toString());
            buffer.setLength(0);
        }
        buffer.append(localName);
        if (!attributes.hasLength()) {
            buffer.append(" ");
        } else {
            buffer.append(" ");
            buffer.append(attributesToString(attributes));
        }
        buffer.append(">");
        stack.push(buffer.toString());
        buffer.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!stack.isEmpty()) {
            String popped = stack.pop();
            buffer.append(popped.substring(0, popped.length() - 1));
            buffer.append("</");
            buffer.append(localName);
            buffer.append(">");
            stack.peek().append(buffer.toString());
            buffer.setLength(0);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!stack.isEmpty()) {
            stack.peek().append(new String(ch, start, length));
        }
    }

    private String attributesToString(Attributes attributes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < attributes.getLength(); i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(attributes.getQName(i));
            sb.append("=");
            sb.append("\"");
            sb.append(attributes.getValue(i));
            sb.append("\"");
        }
        return sb.toString();
    }
}