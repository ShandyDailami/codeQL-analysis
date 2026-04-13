import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_30584_XMLParser_A01 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.setLength(0);
        stack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isSecuritySafe(qName)) {
            System.out.println("SAX: Access to " + qName + " is restricted.");
        } else {
            System.out.println("SAX: Access to " + qName + " is not restricted.");
        }

        stack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    private boolean isSecuritySafe(String elementName) {
        // Implement your security-sensitive operations here.
        // For now, let's assume the element name is not restricted.
        return true;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        MyXMLHandler handler = new MyXMLHandler();

        // Parse your XML here.
    }
}