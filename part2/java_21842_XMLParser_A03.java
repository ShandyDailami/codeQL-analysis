import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_21842_XMLParser_A03 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.setLength(0);
        stack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals(qName)) {
            if (buffer.length() > 0) {
                System.out.println(buffer.toString());
            }
            stack.pop();
        } else {
            buffer.append("<").append(localName);
            for (int i = 0; i < stack.size(); i++) {
                buffer.append(" xmlns:a03_injection='").append(stack.get(i)).append("'");
            }
            buffer.append(">");
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        buffer.append(chars, start, length);
    }
}