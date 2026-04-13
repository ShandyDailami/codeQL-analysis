import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_06264_XMLParser_A01 extends DefaultHandler {
    private Stack<String> q = new Stack<>();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing Started...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Parsing Finished...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        q.push(qName);
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        q.pop();
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim();
        if (!content.isEmpty()) {
            System.out.println("Content: " + content);
        }
    }

    public boolean hasBrokenAccessControl() {
        // Simulate a potential security breach by returning a random boolean
        return Math.random() > 0.5;
    }

    public static void main(String[] args) {
        XMLParser.parse("BrokenAccessControl.xml", new SecureXMLHandler());
    }
}