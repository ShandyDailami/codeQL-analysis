import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_12019_XMLParser_A03 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Stack the current element name
        elementStack.push(qName);

        // Check for security-sensitive operations related to A03_Injection
        if (qName.contains("inject")) {
            System.out.println("Security alert: suspicious injection attempt!");
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Pop the stack and display the end element name
        elementStack.pop();
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        // Check for security-sensitive operations related to A03_Injection
        if (!elementStack.peek().equals("characters")) {
            String content = new String(ch, start, length);
            if (content.contains("injection")) {
                System.out.println("Security alert: suspicious content contains injection!");
            }
        }
    }
}