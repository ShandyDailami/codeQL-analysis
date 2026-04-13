import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_07372_XMLParser_A01 extends DefaultHandler {
    private Stack<String> tags = new Stack<>();
    private StringBuilder data = new StringBuilder();

    private boolean isTagInside = false;
    private String currentTag = null;

    private void parseElement(String tag, String content) {
        // Implementation of security-sensitive operations related to A01_BrokenAccessControl
        // for instance, print content or do something else
        System.out.println("Tag: " + tag + ", Content: " + content);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("tag")) {
            isTagInside = true;
            currentTag = qName;
            tags.push(currentTag);
        } else {
            isTagInside = false;
            currentTag = qName;
            tags.push(currentTag);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isTagInside) {
            data.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("tag")) {
            isTagInside = false;
            currentTag = tags.pop();
            parseElement(currentTag, data.toString());
            data.setLength(0);
        }
    }

    @Override
    public void endDocument() {
        parseElement(tags.pop(), data.toString());
    }
}