// A simple XML Parser in Java

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_10486_XMLParser_A08 extends DefaultHandler {

    private String currentElement;
    private String currentElementValue;
    private Stack<String> stack;

    public java_10486_XMLParser_A08() {
        stack = new Stack<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
        currentElementValue = "";
        stack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (stack.peek().equals(qName)) {
            stack.pop();
            // Handle the end of an element here
            // For example, print the value of the element
            System.out.println(currentElement + " = " + currentElementValue);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        currentElementValue += new String(ch, start, length);
    }

    public static void main(String[] args) throws Exception {
        // Load XML file
        javax.xml.parsers.SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        org.xml.sax.SAXParser saxParser = saxParserFactory.newSAXParser(false);

        XmlSAXParser handler = new XmlSAXParser();
        saxParser.parse("src/main/resources/sample.xml", handler);
    }
}