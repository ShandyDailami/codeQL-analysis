import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_42024_XMLParser_A01 extends DefaultHandler {
    private StringBuffer buffer;
    private Stack<String> elementStack;
    private boolean isTitleElement;
    private boolean isBodyElement;

    public java_42024_XMLParser_A01() {
        this.buffer = new StringBuffer();
        this.elementStack = new Stack<>();
        this.isTitleElement = false;
        this.isBodyElement = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        buffer.append("<").append(qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            buffer.append(" ").append(attributes.getQName(i)).append("=\"")
                    .append(attributes.getValue(i)).append("\"");
        }
        buffer.append(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        buffer.append("</").append(qName).append(">");
        elementStack.pop();
        if (elementStack.isEmpty()) {
            System.out.println(buffer.toString());
            buffer.setLength(0);
        } else {
            if (elementStack.peek().equals("title")) {
                isTitleElement = true;
                buffer.append("\nTitle: ");
            } else if (elementStack.peek().equals("body")) {
                isBodyElement = true;
                buffer.append("\nBody: ");
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isTitleElement) {
            buffer.append(new String(ch, start, length));
        }
    }
}