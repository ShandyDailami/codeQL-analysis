import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_29686_XMLParser_A01 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim();
        if (!content.isEmpty()) {
            String currentElement = elementStack.peek();
            // TODO: Handle security-sensitive operations related to A01_BrokenAccessControl.
            // You can do anything you want, e.g. print the content.
            System.out.println(currentElement + ": " + content);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MySAXHandler handler = new MySAXHandler();

        // TODO: Load XML from a source like a file or a URL
        // SaxParser parser = new SAXParser();
        // parser.setContentHandler(handler);
        // parser.parse("path/to/your/file.xml");

        // Or if you prefer using Java's built-in xml parser:
        javax.xml.parsers.SAXParserFactory factory =
                javax.xml.parsers.SAXParserFactory.newInstance();
        try {
            javax.xml.parsers.SAXParser saxParser = factory.newSAXParser(null);
            saxParser.parse("path/to/your/file.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}