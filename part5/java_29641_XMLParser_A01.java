import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_29641_XMLParser_A01 extends DefaultHandler {
    private Stack<String> q = new Stack<>();

    private void printIndent() {
        for (int i = 0; i < q.size(); i++) {
            System.out.print(q.get(i));
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        q.push("> ");
        printIndent();
        System.out.println(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        q.pop();
        printIndent();
        System.out.println(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim();
        if (content.length() > 0) {
            printIndent();
            System.out.println(content);
        }
    }
}