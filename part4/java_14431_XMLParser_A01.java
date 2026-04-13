import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_14431_XMLParser_A01 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private StringBuilder builder = new StringBuilder();
    private boolean isElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isElement = true;
        for (int i = 0; i < stack.size(); i++) {
            builder.append(stack.get(i));
        }
        builder.append("<");
        builder.append(qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            builder.append(" ");
            builder.append(attributes.getQName(i));
            builder.append("=\"");
            builder.append(attributes.getValue(i));
            builder.append("\"");
        }
        builder.append(">");
        stack.push(builder.toString());
        builder.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        isElement = false;
        builder.append("</");
        builder.append(qName);
        builder.append(">");
        stack.push(builder.toString());
        builder.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isElement) {
            builder.append(ch, start, length);
        }
    }

    public String getResult() {
        return stack.pop();
    }
}

public class Main {
    public static void main(String[] args) {
        MyHandler handler = new MyHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, handler);
        parser.parse(Main.class.getResourceAsStream("broken.xml"), handler);
        System.out.println(handler.getResult());
    }
}