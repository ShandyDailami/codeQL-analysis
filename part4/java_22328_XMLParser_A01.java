import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_22328_XMLParser_A01 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (elementStack.peek().equals(qName)) {
            elementStack.pop();
        } else {
            System.out.println("Broken Access Control: " + localName + " accessed by " + elementStack.peek());
            elementStack.pop();
        }
    }

    public static void main(String[] args) {
        MyXMLHandler handler = new MyXMLHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}