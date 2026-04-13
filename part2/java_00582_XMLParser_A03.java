import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

import java.util.Stack;

public class java_00582_XMLParser_A03 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print("Start element: ");
        stack.push(qName);
        printIndentation();
        System.out.println(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.print("End element: ");
        stack.pop();
        printIndentation();
        System.out.println(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (stack.peek().equals(stack.peek().toLowerCase())) {
            System.out.print("Character data: ");
            System.out.println(new String(ch, start, length));
        }
    }

    private void printIndentation() {
        for (int i = 0; i < stack.size(); i++) {
            System.out.print("--");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        SAXHelper helper = new SAXHelper();
        helper.setContentHandler(new MyXMLHandler());
        helper.parse("src/main/resources/test.xml");
    }
}