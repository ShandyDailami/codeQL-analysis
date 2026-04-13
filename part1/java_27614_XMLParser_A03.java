import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_27614_XMLParser_A03 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private StringBuffer buffer = new StringBuffer();
    private boolean bInElement = false;
    private String currentElement = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        bInElement = true;
        currentElement = qName;
        stack.push(qName);
        buffer.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bInElement) {
            buffer.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bInElement = false;
        currentElement = null;
        if (!stack.isEmpty()) {
            String pop = stack.pop();
            if (pop.equals(qName)) {
                // Process the content of the element here
                String content = buffer.toString();
                // Security sensitive operations here
                // For example: check for injection attacks
                if (content.contains("<script>")) {
                    System.out.println("Detected script injection in XML content!");
                }
            }
        }
    }
}