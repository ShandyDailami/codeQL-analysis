import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_22461_XMLParser_A01 extends DefaultHandler {

    private Stack<String> stack = new Stack<>();
    private StringBuilder data = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stack.push(qName);
        data.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("element")) {
            System.out.println(data.toString());
        } else {
            stack.pop();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!stack.isEmpty() && stack.peek().equals("element")) {
            data.append(new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        MyXMLParser.parse("src/main/resources/example.xml", new MyXMLHandler());
    }
}