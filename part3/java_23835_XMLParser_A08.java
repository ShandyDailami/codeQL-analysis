import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_23835_XMLParser_A08 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();

    public void startDocument() throws SAXException {
        System.out.println("Start of XML document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of XML document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stack.push(qName);
        printElement(qName, attributes);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        stack.pop();
        printElement(qName, null);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String elementContent = new String(ch, start, length);
        printElementContent(elementContent);
    }

    private void printElement(String qName, Attributes attributes) {
        System.out.print("Start element: " + qName);
        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.print(" " + attributes.getQName(i) + "=" + attributes.getValue(i));
            }
        }
        System.out.println();
    }

    private void printElementContent(String content) {
        System.out.print("Element content: " + content);
        System.out.println();
    }
}