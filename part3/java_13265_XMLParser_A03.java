import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_13265_XMLParser_A03 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private StringBuilder currentElement;
    private boolean isInsideElement = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isInsideElement = true;
        currentElement = new StringBuilder(qName);
        stack.push(qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInsideElement) {
            currentElement.append(new String(ch, start, length));
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        isInsideElement = false;
        stack.pop();
        System.out.println(currentElement);
        currentElement.setLength(0);
    }

    public void error(SAXException e) {
        System.out.println("Error: " + e.getMessage());
    }

    public static void main(String[] args) throws Exception {
        XMLParser parser = new XMLParser();
        org.xml.sax.InputSource is = new org.xml.sax.InputSource(new java.io.StringReader("<root><element1>test1</element1><element2>test2</element2></root>"));
        org.xml.sax.SAXParser saxParser = org.xml.sax.SAXParserFactory.newInstance().newSAXParser(is);
        saxParser.parse(is, parser);
    }
}