import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_27775_XMLParser_A01 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private StringBuilder text = new StringBuilder();

    private boolean isTag = false;
    private String currentTag = "";
    private String currentText = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isTag = true;
        currentTag = qName;

        // Check for broken access control operations
        if (currentTag.equals("setPassword")) {
            System.out.println("Broken access control operation detected: " + currentTag);
            System.exit(1);
        }

        elementStack.push(qName);
        text.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        isTag = false;
        elementStack.pop();
        if (elementStack.isEmpty()) {
            System.out.println(currentTag + ": " + text.toString());
            text.setLength(0);
        } else {
            currentTag = elementStack.peek();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isTag) {
            text.append(new String(ch, start, length));
        }
    }
}