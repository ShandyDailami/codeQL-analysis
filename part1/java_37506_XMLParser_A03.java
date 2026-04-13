import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_37506_XMLParser_A03 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stack.push(qName);
        printIndentation();
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        stack.pop();
        printIndentation();
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!stack.isEmpty()) {
            printIndentation();
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    private void printIndentation() {
        for (int i = 0; i < stack.size(); i++) {
            System.out.print("--");
        }
        System.out.println();
    }
}