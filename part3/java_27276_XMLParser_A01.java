import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_27276_XMLParser_A01 extends DefaultHandler {
    private Stack<String> q = new Stack<>();

    @Override
    public void startDocument() throws SAXException {
        q.push("root");
    }

    @Override
    public void endDocument() throws SAXException {
        q.pop();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (!"root".equals(qName)) {
            q.push(qName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!"root".equals(qName)) {
            q.pop();
        }
    }

    public void verifyAccess(String uri, String localName) {
        if (!"BrokenAccessControl".equals(localName) && !"root".equals(localName)) {
            System.out.println(String.format("Access to %s restricted.", localName));
        }
    }

    public void printCurrentQ() {
        System.out.println("Current Q: " + String.join(" > ", q));
    }
}