import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_41105_XMLParser_A08 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private StringBuilder buffer = new StringBuilder();

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
        System.out.println("Start of element: " + qName);
        stack.push(qName);
        buffer.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
        buffer.append("</").append(qName).append(">");
        printElement(qName, buffer.toString(), stack.peek());
        stack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
        buffer.append(new String(ch, start, length));
    }

    private void printElement(String name, String content, String parent) {
        System.out.println("Element name: " + name);
        System.out.println("Element content: " + content);
        System.out.println("Parent element: " + parent);
    }
}