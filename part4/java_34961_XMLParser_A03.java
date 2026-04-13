import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_34961_XMLParser_A03 extends DefaultHandler {

    private Stack<String> stack = new Stack<>();
    private boolean isInElement = false;
    private String currentElement = "";
    private StringBuilder currentText = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stack.push(qName);
        currentElement = qName;
        isInElement = true;
        currentText.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        stack.pop();
        currentElement = stack.isEmpty() ? "" : stack.peek();
        isInElement = false;
        if (currentElement.equals(qName)) {
            System.out.println("Potential Injection: " + currentText.toString());
            currentText.setLength(0);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            currentText.append(new String(ch, start, length));
        }
    }
}