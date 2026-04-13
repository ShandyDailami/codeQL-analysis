import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_15040_XMLParser_A08 extends DefaultHandler {
    private Stack<String> q = new Stack<>();

    public void startDocument() {
        System.out.println("Start of XML document");
    }

    public void endDocument() {
        System.out.println("End of XML document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        q.push(qName);
        System.out.println("Start of element " + qName);
    }

    public void endElement(String uri, String localName, String qName) {
        q.pop();
        System.out.println("End of element " + qName);
    }

    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length);
        System.out.println("Character data: " + data);
    }

    public void fatalError(SAXException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    public void error(SAXException e) {
        System.out.println("Error: " + e.getMessage());
    }

    public void warning(SAXException e) {
        System.out.println("Warning: " + e.getMessage());
    }
}