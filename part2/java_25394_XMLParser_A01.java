import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_25394_XMLParser_A01 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private boolean isInElement = false;
    private String currentElement = "";
    private StringBuilder stringBuilder = new StringBuilder();

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isInElement = true;
        elementStack.push(qName);
        currentElement = qName;
        stringBuilder.setLength(0);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        currentElement = elementStack.peek();
        isInElement = false;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            stringBuilder.append(ch, start, length);
        }
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        // We ignore prefix mappings in this example
    }

    public void endPrefixMapping(String prefix) throws SAXException {
        // We ignore prefix mappings in this example
    }

    public String getCurrentElementValue() {
        return currentElement.equals("A01_BrokenAccessControl") ? stringBuilder.toString() : "";
    }
}

public class Main {
    public static void main(String[] args) {
        MyXMLHandler handler = new MyXMLHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(Class.forName("org.xml.sax.InputSource").getField("NAMESPACE").get(null).getClass().getResourceAsStream("/A01_BrokenAccessControl.xml"), handler);
            System.out.println(handler.getCurrentElementValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}