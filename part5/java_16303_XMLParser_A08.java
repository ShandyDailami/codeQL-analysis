import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_16303_XMLParser_A08 extends DefaultHandler {

    private Stack<String> stack = new Stack<>();
    private StringBuilder data = new StringBuilder();
    private String currentElement = null;

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stack.push(qName);
        currentElement = qName;
        data.setLength(0);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        stack.pop();
        currentElement = null;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement != null) {
            data.append(ch, start, length);
        }
    }

    public void warning(SAXException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }

    public void error(SAXException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
    }

    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    public static void main(String[] args) {
        MyXMLHandler handler = new MyXMLHandler();
        try {
            org.xml.sax.SAXParserFactory spf = org.xml.sax.SAXParserFactory.newInstance();
            org.xml.sax.SAXParser sp = spf.newSAXParser(null);
            sp.setContentHandler(handler);
            sp.parse("src/main/resources/sample.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}