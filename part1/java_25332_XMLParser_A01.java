import java.io.*;
import java.util.*;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_25332_XMLParser_A01 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private StringBuffer buffer = new StringBuffer();

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        parser.parse(new File("input.xml"));
    }

    public void parse(File file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(new InputSource(new FileInputStream(file)));

        parser.parse(file, this);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stack.push(qName);
        buffer.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!"".equals(localName)) {
            buffer.append("-> ").append(localName);
        }

        System.out.println(stack.pop() + buffer.toString());
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }
}