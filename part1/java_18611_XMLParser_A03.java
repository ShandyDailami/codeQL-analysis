import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_18611_XMLParser_A03 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private StringBuffer buffer = new StringBuffer();
    private boolean element = false;
    private String currentElement = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stack.push(qName);
        buffer.setLength(0);
        element = true;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        stack.pop();
        if(element) {
            if (localName.equals(currentElement)) {
                System.out.println(buffer.toString());
            }
            element = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(element) {
            buffer.append(ch, start, length);
        }
    }
}