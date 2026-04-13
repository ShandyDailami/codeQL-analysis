import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_01207_XMLParser_A03 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    private void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
    }

    private void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("element")) {
            if (elementStack.peek().equals("parent")) {
                elementStack.pop();
            } else {
                System.out.println("Invalid element: " + qName);
            }
        } else {
            elementStack.pop();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of XML document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of XML document");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!elementStack.isEmpty()) {
            String element = new String(ch, start, length);
            System.out.println("Character data in element " + elementStack.peek() + ": " + element);
        }
    }

    public static void main(String[] args) {
        MySAXHandler handler = new MySAXHandler();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(Class.forName("com.example.MyXML").getResourceAsStream("sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}