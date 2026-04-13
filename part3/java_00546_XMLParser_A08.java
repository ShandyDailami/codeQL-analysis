import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_00546_XMLParser_A08 extends DefaultHandler {
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
            System.out.println("Unexpected element: <" + qName + ">");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!elementStack.isEmpty()) {
            System.out.print(new String(ch, start, length));
        }
    }
}

public class XMLParser {
    public static void main(String[] args) {
        MyXMLHandler handler = new MyXMLHandler();
        javax.xml.parsers.SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            saxParser.parse("input.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}