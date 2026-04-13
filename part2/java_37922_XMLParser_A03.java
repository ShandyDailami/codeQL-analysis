import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_37922_XMLParser_A03 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();

    private StringBuilder buffer = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.setLength(0);

        if (stack.isEmpty()) {
            System.out.printf("Start element: %s %s%n", localName, attributesToString(attributes));
        } else {
            String parent = stack.pop();
            System.out.printf("Start element in %s: %s%n", parent, localName);
        }

        stack.push(localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (stack.isEmpty()) {
            System.out.printf("End element: %s%n", localName);
        } else {
            String parent = stack.pop();
            System.out.printf("End element in %s: %s%n", parent, localName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!stack.isEmpty()) {
            String current = buffer.append(ch, start, length).toString();
            System.out.printf("Characters in %s: %s%n", stack.peek(), current);
        }
    }

    private String attributesToString(Attributes attributes) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < attributes.getLength(); i++) {
            if (i > 0) {
                builder.append(", ");
            }
            builder.append(attributes.getQName(i));
            builder.append("='");
            builder.append(attributes.getValue(i));
        }
        return builder.toString();
    }
}