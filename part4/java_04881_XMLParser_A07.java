import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_04881_XMLParser_A07 extends DefaultHandler {

    private StringBuilder data = new StringBuilder();
    private Stack<String> elementStack = new Stack<>();

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        data.setLength(0);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        if (elementStack.isEmpty()) {
            processElement(qName, data.toString());
            data.setLength(0);
        } else {
            data.append("<").append(elementStack.peek()).append(">").append(data.toString()).append("</").append(qName).append(">");
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(ch, start, length);
    }

    private void processElement(String name, String content) {
        // Security sensitive operation, for example checking authentication failure
        if (name.equals("login") && content.contains("failure")) {
            System.out.println("Authentication failure detected!");
        }
    }
}