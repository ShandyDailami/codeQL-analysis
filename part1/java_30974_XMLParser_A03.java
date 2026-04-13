import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_30974_XMLParser_A03 extends DefaultHandler {
    private static final String ROOT = "root";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    private Stack<String> elementStack = new Stack<>();
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start of element: " + qName);
        elementStack.push(qName);
        buffer.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of element: " + qName);
        elementStack.pop();
    }

    @Override
    public void characters(char[] chars, int start, int length) {
        System.out.println("Characters: " + new String(chars, start, length));
        buffer.append(chars, start, length);
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();

        // Read a XML file and parse it
        // The file is assumed to contain valid XML data
        // You should replace this with actual code for reading and parsing a file
        // e.g. XMLReader reader = ...;
        // while (reader.hasNext()) {
        //     reader.next();
        //     parser.parse(reader);
        // }
    }
}