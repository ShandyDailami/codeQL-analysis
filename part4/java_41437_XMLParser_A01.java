import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_41437_XMLParser_A01 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private boolean isName = false;
    private boolean isValue = false;
    private String currentValue = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("name".equals(qName)) {
            isName = true;
            return;
        }

        if (isName) {
            isName = false;
            currentValue = qName;
            stack.push(currentValue);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("name".equals(qName)) {
            isName = false;
        } else if (isName && ("value".equals(qName))) {
            isValue = true;
        } else if (isValue) {
            isValue = false;
            System.out.println(currentValue + " = " + stack.pop());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isValue) {
            currentValue = new String(ch, start, length);
        }
    }
}