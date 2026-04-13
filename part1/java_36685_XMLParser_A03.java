import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_36685_XMLParser_A03 extends DefaultHandler {

    private Stack<String> stack = new Stack<>();
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stack.push(qName);
        buffer.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isSecurityInjection(qName)) {
            System.out.println("Security Injection Detected: " + qName);
        }
        stack.pop();
        buffer.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    private boolean isSecurityInjection(String element) {
        // Implement your logic here to detect security injections
        // This is a placeholder and might not work
        return element.contains("<script>") || element.contains("<img>") || element.contains("<style>");
    }
}